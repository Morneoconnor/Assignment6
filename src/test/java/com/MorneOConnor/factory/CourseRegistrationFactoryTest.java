package com.MorneOConnor.factory;

import com.MorneOConnor.domain.CourseRegistration;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseRegistrationFactoryTest {
    @Test
    public void createCourseRegistration() {
        String name = "AppDev";
        int id = 111;
        CourseRegistration obj = CourseRegistrationFactory.createCourseRegistration
                (name, id);
        Assert.assertEquals("AppDev",obj.getCourseName());
        Assert.assertEquals(111,obj.getCourseId());
    }
}



