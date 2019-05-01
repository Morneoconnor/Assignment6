package com.MorneOConnor.factory;

import com.MorneOConnor.domain.Student;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentFactoryTest {
    @Test
    public void createStudent() {
        String name = "name";
        String courseName = "App Dev";
        String studentNumber = "1234";
        Student obj = StudentFactory.createStudent
        (name,courseName, studentNumber);
        Assert.assertEquals("name",obj.getStudentName());
        Assert.assertEquals("App Dev",obj.getCourseName());
        Assert.assertEquals("1234",obj.getStudentNumber());
        }
        }