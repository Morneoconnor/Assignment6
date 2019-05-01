package com.MorneOConnor.repository;

import com.MorneOConnor.domain.CourseRegistration;
import com.MorneOConnor.factory.CourseRegistrationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class CourseRegistrationRepositoryTest {
    private CourseRegistrationRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = CourseRegistrationRepository.getRepository();
    }

    @Test
    public void create() throws Exception {
        CourseRegistration obj = CourseRegistrationFactory.createCourseRegistration
                ("Test",111);

        this.repository.create(obj);
        Assert.assertEquals("Test", obj.getCourseName());
    }

    @Test
    public void read() throws Exception {
        Object obj = this.repository.read(111);
        Assert.assertNull(obj);
    }

    @Test
    public void update() throws Exception {
        CourseRegistration obj = CourseRegistrationFactory.createCourseRegistration
                ("Test", 111);
        Assert.assertEquals("Test", obj.getCourseName());
    }

    @Test
    public void delete() throws Exception {
        boolean item = false;

        this.repository.delete(111);
        Set<CourseRegistration> obj = this.repository.getAll();
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
        Set<CourseRegistration> obj = this.repository.getAll();
        Assert.assertNotNull(obj);
    }

}