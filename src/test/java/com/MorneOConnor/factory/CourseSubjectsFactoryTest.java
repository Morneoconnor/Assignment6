package com.MorneOConnor.factory;

import com.MorneOConnor.domain.CourseSubjects;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseSubjectsFactoryTest {
    @Test
    public void createCourseRegistration(){
            String name = "ProfCom";
            int id = 111;
            CourseSubjects obj = CourseSubjectsFactory.createCourseRegistration
                    (name, id);
            Assert.assertEquals("ProfCom",obj.getSubjectName());
            Assert.assertEquals(111,obj.getSubjectId());
        }
    }
