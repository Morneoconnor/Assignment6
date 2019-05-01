package com.MorneOConnor.repository;

import com.MorneOConnor.domain.AuthenticationQuestions;
import com.MorneOConnor.factory.AuthenticationQuestionsFactory;
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
        AuthenticationQuestions obj = AuthenticationQuestionsFactory.createAuthenticationQuestions
                ("mom","dad","111");

        this.repository.create(obj);
        Assert.assertEquals("dad", obj.getFatherName());
    }

    @Test
    public void read() throws Exception {
        AuthenticationQuestions obj = this.repository.read("111");
        Assert.assertEquals("mom",obj.getMotherName());

    }

    @Test
    public void update() throws Exception {
        AuthenticationQuestions obj = AuthenticationQuestionsFactory.createAuthenticationQuestions
                ("mom","dad","111");
        Assert.assertEquals("mom", obj.getMotherName());
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        Set<AuthenticationQuestions> students = this.repository.getAll();
        Assert.assertEquals(1, students.size());
    }

}