package com.MorneOConnor.controller;

import com.MorneOConnor.domain.AuthenticationQuestions;
import com.MorneOConnor.factory.AuthenticationQuestionsFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class AuthenticationQuestionsControllerTest {
    @Autowired

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/authenticationquestions";
    @Ignore
    public void create() throws Exception {
        AuthenticationQuestions authenticationquestions =
                AuthenticationQuestionsFactory.createAuthenticationQuestions("mom"," dad",1);

        ResponseEntity<AuthenticationQuestions> postResponse = restTemplate.postForEntity(baseURL + "/create", authenticationquestions, AuthenticationQuestions.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void update() throws Exception {
        int id = 1;
        AuthenticationQuestions authenticationquestions = restTemplate.getForObject(baseURL + "/authenticationquestions/" + id, AuthenticationQuestions.class);

        restTemplate.put(baseURL + "/authenticationquestions/" + id, authenticationquestions);
        AuthenticationQuestions updateAuthenticationQuestions = restTemplate.getForObject(baseURL + "/authenticationquestions/" + id, AuthenticationQuestions.class);
        assertNotNull(updateAuthenticationQuestions);
    }

    @Ignore
    public void delete() throws Exception {
        int id = 2;
        AuthenticationQuestions authenticationquestions = restTemplate.getForObject(baseURL + "/authenticationquestions/" + id, AuthenticationQuestions.class);
        assertNotNull(authenticationquestions);
        restTemplate.delete(baseURL + "/students/" + id);
        try {
            authenticationquestions = restTemplate.getForObject(baseURL + "/students/" + id, AuthenticationQuestions.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Ignore
    public void read() throws Exception {
        AuthenticationQuestions authenticationQuestions = restTemplate.getForObject(baseURL + "/authenticationquestions/1", AuthenticationQuestions.class);
        System.out.println(authenticationQuestions.getMotherName());
        assertNotNull(authenticationQuestions);
    }

    @Test
    public void getAll() throws Exception {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}