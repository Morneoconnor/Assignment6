package com.MorneOConnor.service;

import com.MorneOConnor.domain.CourseRegistration;
import com.MorneOConnor.factory.CourseRegistrationFactory;
import com.MorneOConnor.repository.CourseRegistrationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class CourseRegistrationServiceTest {
    private CourseRegistrationRepository repository;
    private CourseRegistration password;

    private CourseRegistration getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CourseRegistrationRepository.getRepository();
        this.password = CourseRegistrationFactory.createCourseRegistration("App Dev",123);
    }

    @Test
    public void create() throws Exception {
        CourseRegistration created = this.repository.create(this.password);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.password);
    }

    @Test
    public void update() throws Exception {
        int newCourseId = 123;
        CourseRegistration updated = new CourseRegistration.Builder().copy(getSaved()).courseId(newCourseId).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCourseId, updated.getCourseId());
    }

    @Test
    public void delete() throws Exception {
        CourseRegistration saved = getSaved();
        this.repository.delete(saved.getCourseId());
        getAll();
    }

    @Test
    public void read() throws Exception {
        CourseRegistration saved = getSaved();
        CourseRegistration read = this.repository.read(saved.getCourseId());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void getAll() throws Exception {
        Set<CourseRegistration> password = this.repository.getAll();
        System.out.println("In getall, all = " + password);
    }
}