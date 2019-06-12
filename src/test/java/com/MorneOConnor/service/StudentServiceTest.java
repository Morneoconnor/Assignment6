package com.MorneOConnor.service;

import com.MorneOConnor.domain.Student;
import com.MorneOConnor.factory.StudentFactory;
import com.MorneOConnor.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class StudentServiceTest {
    private StudentRepository repository;
    private Student password;

    private Student getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StudentRepository.getRepository();
        this.password = StudentFactory.createStudent("Morne", "App Dev"
                , "1234");
    }

    @Test
    public void create() throws Exception {
        Student created = this.repository.create(this.password);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.password);
    }

    @Test
    public void update() throws Exception {
        String courseName = "Networking";
        Student updated = new Student.Builder().copy(getSaved()).courseName(courseName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(courseName, updated.getCourseName());
    }

    @Test
    public void read() throws Exception {
        Student saved = getSaved();
        Student read = this.repository.read(saved.getCourseName());
        Assert.assertNull(read);
    }

    @Test
    public void delete() throws Exception {
        Student saved = getSaved();
        this.repository.delete(saved.getCourseName());
        getAll();
    }

    @Test
    public void getAll() throws Exception {
        Set<Student> password = this.repository.getAll();
        System.out.println(password);
    }
}