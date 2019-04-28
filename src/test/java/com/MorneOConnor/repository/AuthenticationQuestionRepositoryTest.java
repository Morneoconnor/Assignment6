package com.MorneOConnor.repository;

import com.MorneOConnor.domain.AuthenticationQuestions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class AuthenticationQuestionRepositoryTest {
    private AuthenticationQuestionRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = AuthenticationQuestionRepository.getRepository();
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
        Set<AuthenticationQuestions> students = this.repository.getAll();
        Assert.assertEquals(1, students.size());
    }

}