package com.MorneOConnor.factory;

import com.MorneOConnor.domain.StudentPersonalInformation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentPersonalInformationFactoryTest {
    @Test
    public void createStudentPersonalInformation() {
        String name = "name";
        String surName = "O'Connor";
        String studentNumber = "1234";
        String studentId = "1234";
        String emailAddress = "morne@test.com";
        StudentPersonalInformation obj = StudentPersonalInformationFactory.createStudentPersonalInformation
                (name, surName,studentId, studentNumber, emailAddress);
        Assert.assertEquals("name",obj.getStudentName());
        Assert.assertEquals("O'Connor",obj.getStudentSurName());
        Assert.assertEquals("1234",obj.getStudentIdNumber());
        Assert.assertEquals("morne@test.com",obj.getEmailAddress());
        Assert.assertEquals("1234",obj.getStudentId());
    }
}