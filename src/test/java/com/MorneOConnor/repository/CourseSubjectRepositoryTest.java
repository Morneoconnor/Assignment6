package com.MorneOConnor.repository;

import com.MorneOConnor.domain.CourseSubjects;
import com.MorneOConnor.factory.CourseSubjectsFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class CourseSubjectRepositoryTest {
    private CourseSubjectRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = CourseSubjectRepository.getRepository();
    }

    @Test
    public void create() throws Exception {
        CourseSubjects obj = CourseSubjectsFactory.createCourseRegistration
                ("Test",111);

        this.repository.create(obj);
        Assert.assertEquals("Test", obj.getSubjectName());
    }

    @Test
    public void read() throws Exception {
        Object obj = this.repository.read(111);
        Assert.assertNull(obj);
    }

    @Test
    public void update() throws Exception {
        CourseSubjects obj = CourseSubjectsFactory.createCourseRegistration
                ("Test", 111);
        Assert.assertEquals("Test", obj.getSubjectName());
    }

    @Test
    public void delete() throws Exception {
        boolean item = false;

        this.repository.delete(111);
        Set<CourseSubjects> obj = this.repository.getAll();
        if(obj.contains(111))
        {
            item = true;
        }
        else
            item = false;
        assertFalse(item);
    }

    @Test
    public void getAll() throws Exception {
        Set<CourseSubjects> obj = this.repository.getAll();
        Assert.assertNotNull(obj);
    }

}