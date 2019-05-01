package com.MorneOConnor.repository;

import com.MorneOConnor.domain.StudentPersonalInformation;
import com.MorneOConnor.factory.StudentPersonalInformationFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class StudentPersonalInformationRepositoryTest {
    private StudentPersonalInformationRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = StudentPersonalInformationRepository.getRepository();
    }

    @Test
    public void create() throws Exception {
        StudentPersonalInformation obj = StudentPersonalInformationFactory.createStudentPersonalInformation
                ("Morne","OConnor", "111","890621","morne@test.com");

        this.repository.create(obj);
        Assert.assertEquals("890621", obj.getStudentIdNumber());
    }

    @Test
    public void read() throws Exception {
        Object obj = this.repository.read("111");
        Assert.assertNull(obj);
    }

    @Test
    public void update() throws Exception {
        StudentPersonalInformation obj = StudentPersonalInformationFactory.createStudentPersonalInformation
                ("Morne","OConnor", "111","890621","morne@test.com");

        Assert.assertEquals("890621", obj.getStudentIdNumber());
    }

    @Test
    public void delete() throws Exception {
        boolean item = false;

        this.repository.delete("111");
        Set<StudentPersonalInformation> obj = this.repository.getAll();
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
        Set<StudentPersonalInformation> obj = this.repository.getAll();
        Assert.assertNotNull(obj);
    }

}