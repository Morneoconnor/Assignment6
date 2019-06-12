package com.MorneOConnor.repository;

import com.MorneOConnor.domain.AuthenticationQuestions;
import com.MorneOConnor.factory.AuthenticationQuestionsFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.management.DynamicMBean;
import java.util.Set;

import static org.junit.Assert.*;

public class AuthenticationQuestionRepositoryTest {
    @Autowired

    private AuthenticationQuestionRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = AuthenticationQuestionRepository.getRepository();
    }

    @Test
    public void create() throws Exception {
        AuthenticationQuestions obj = AuthenticationQuestionsFactory.createAuthenticationQuestions
                ("mom","dad",1);

        this.repository.create(obj);
        Assert.assertEquals("dad", obj.getFatherName());
    }

    @Test
    public void read() throws Exception {
        Object obj = this.repository.read("333");
        Assert.assertNull(obj);

    }

    @Test
    public void update() throws Exception {
        AuthenticationQuestions obj = AuthenticationQuestionsFactory.createAuthenticationQuestions
                ("mom","dad",1);
        Assert.assertEquals("mom", obj.getMotherName());
    }

    @Test
    public void delete() throws Exception {
        boolean item = false;
        this.repository.delete("111");
        Set<AuthenticationQuestions> obj = this.repository.getAll();
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
        Set<AuthenticationQuestions> obj = this.repository.getAll();
        Assert.assertNotNull(obj);
    }

}