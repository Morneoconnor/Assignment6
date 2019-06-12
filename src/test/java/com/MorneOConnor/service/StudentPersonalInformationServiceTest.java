package com.MorneOConnor.service;

import com.MorneOConnor.domain.StudentPersonalInformation;
import com.MorneOConnor.factory.StudentPersonalInformationFactory;
import com.MorneOConnor.repository.StudentPersonalInformationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class StudentPersonalInformationServiceTest {
    private StudentPersonalInformationRepository repository;
    private StudentPersonalInformation password;

    private StudentPersonalInformation getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StudentPersonalInformationRepository.getRepository();
        this.password = StudentPersonalInformationFactory.createStudentPersonalInformation("Morne","OConnor"
        ,"1234","890621","morne@test.com");
    }

    @Test
    public void create() throws Exception {
        StudentPersonalInformation created = this.repository.create(this.password);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.password);
    }

    @Test
    public void update() throws Exception {
        String email = "morneocon@test.com";
        StudentPersonalInformation updated = new StudentPersonalInformation.Builder().copy(getSaved()).emailAddress(email).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(email, updated.getEmailAddress());
    }

    @Test
    public void read() throws Exception {
        StudentPersonalInformation saved = getSaved();
        StudentPersonalInformation read = this.repository.read(saved.getEmailAddress());
        Assert.assertNull(read);
    }

    @Test
    public void delete() throws Exception {
        StudentPersonalInformation saved = getSaved();
        this.repository.delete(saved.getEmailAddress());
        getAll();
    }

    @Test
    public void getAll() throws Exception {
        Set<StudentPersonalInformation> password = this.repository.getAll();
        System.out.println(password);
    }
}