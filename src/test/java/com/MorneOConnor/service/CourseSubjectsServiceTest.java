package com.MorneOConnor.service;

import com.MorneOConnor.domain.CourseSubjects;
import com.MorneOConnor.factory.CourseSubjectsFactory;
import com.MorneOConnor.repository.CourseSubjectRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class CourseSubjectsServiceTest {
    private CourseSubjectRepository repository;
    private CourseSubjects subject;

    private CourseSubjects getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CourseSubjectRepository.getRepository();
        this.subject = CourseSubjectsFactory.createCourseRegistration("App Dev",123);
    }

    @Test
    public void create() throws Exception {
        CourseSubjects created = this.repository.create(this.subject);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.subject);
    }

    @Test
    public void update() throws Exception {
        int newSubjectId = 123;
        CourseSubjects updated = new CourseSubjects.Builder().copy(getSaved()).subjectId(newSubjectId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newSubjectId, updated.getSubjectId());
    }

    @Test
    public void delete() throws Exception {
        CourseSubjects saved = getSaved();
        this.repository.delete(saved.getSubjectId());
        getAll();
    }

    @Test
    public void read() throws Exception {
        CourseSubjects saved = getSaved();
        CourseSubjects read = this.repository.read(saved.getSubjectId());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void getAll() throws Exception {
        Set<CourseSubjects> password = this.repository.getAll();
        System.out.println("In getall, all = " + password);
    }
}