package com.MorneOConnor.service;

import com.MorneOConnor.domain.AuthenticationQuestions;
import com.MorneOConnor.factory.AuthenticationQuestionsFactory;
import com.MorneOConnor.repository.AuthenticationQuestionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static org.junit.Assert.*;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthenticationQuestionServiceTest {
    private AuthenticationQuestionRepository repository;
    private AuthenticationQuestions question;

    private AuthenticationQuestions getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AuthenticationQuestionRepository.getRepository();
        this.question = AuthenticationQuestionsFactory.createAuthenticationQuestions("Mom","Dad","123");
    }

    @Test
    public void create() throws Exception {
        AuthenticationQuestions created = this.repository.create(this.question);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.question);
    }

    @Test
    public void update() throws Exception {
        String newMom = "Mom";
        AuthenticationQuestions updated = new AuthenticationQuestions.Builder().copy(getSaved()).motherName(newMom).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newMom, updated.getMotherName());
    }

    @Test
    public void delete() throws Exception {
        AuthenticationQuestions saved = getSaved();
        this.repository.delete(saved.getId());
        getAll();
    }

    @Test
    public void read() throws Exception {
        AuthenticationQuestions saved = getSaved();
        AuthenticationQuestions read = this.repository.read(saved.getId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void getAll() throws Exception {
        Set<AuthenticationQuestions> questions = this.repository.getAll();
        System.out.println("In getall, all = " + questions);
    }

}