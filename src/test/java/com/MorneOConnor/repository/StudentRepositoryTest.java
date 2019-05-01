package com.MorneOConnor.repository;

import com.MorneOConnor.domain.Student;
import com.MorneOConnor.domain.StudentPersonalInformation;
import com.MorneOConnor.factory.StudentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class StudentRepositoryTest {
    private StudentRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = StudentRepository.getRepository();
    }

    @Test
    public void create() throws Exception {
        Student obj = StudentFactory.createStudent
                ("Test", "Test","111");

        this.repository.create(obj);
        Assert.assertEquals("111", obj.getStudentNumber());
    }

    @Test
    public void read() throws Exception {
        Object obj = this.repository.read("111");
        Assert.assertNull(obj);
    }

    @Test
    public void update() throws Exception {
        Student obj = StudentFactory.createStudent
                ("Test","Test","111");

        Assert.assertEquals("111", obj.getStudentNumber());
    }

    @Test
    public void delete() throws Exception {
        boolean item = false;

        this.repository.delete("111");
        Set<Student> obj = this.repository.getAll();
        if(obj.contains("111"))
        {
            item = true;
        }
        else
            item = false;
        assertFalse(item);
    }

    @Test
    public void getAll() throws Exception {
        Set<Student> obj = this.repository.getAll();
        Assert.assertNotNull(obj);
    }

}