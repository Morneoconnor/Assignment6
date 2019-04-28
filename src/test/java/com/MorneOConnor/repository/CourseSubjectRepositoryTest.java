package com.MorneOConnor.repository;

import com.MorneOConnor.domain.CourseSubjects;
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
        this.repository.create(null);
        Assert.assertEquals(null, null);
    }

    @Test
    public void read() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        Set<CourseSubjects> students = this.repository.getAll();
        Assert.assertEquals(1, students.size());
    }

}