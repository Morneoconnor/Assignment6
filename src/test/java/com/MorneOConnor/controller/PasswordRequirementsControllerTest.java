package com.MorneOConnor.controller;

import com.MorneOConnor.domain.PasswordRequirements;
import com.MorneOConnor.factory.PasswordRequirementsFactory;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class PasswordRequirementsControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/passwordrequirements";

    @Test
    public void create() throws Exception {
        PasswordRequirements passwordrequirements =
                PasswordRequirementsFactory.createPasswordRequirements("PPPPPP", 6, 1);

        ResponseEntity<PasswordRequirements> postResponse = restTemplate.postForEntity(baseURL + "/create", passwordrequirements, PasswordRequirements.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() throws Exception {
        int id = 1;
        PasswordRequirements passwordrequirements = restTemplate.getForObject(baseURL + "/passwordrequirements/" + id, PasswordRequirements.class);

        restTemplate.put(baseURL + "/passwordrequirements/" + id, passwordrequirements);
        PasswordRequirements updatedpasswordrequirements = restTemplate.getForObject(baseURL + "/passwordrequirements/" + id, PasswordRequirements.class);
        assertNotNull(updatedpasswordrequirements);
    }

    @Test
    public void delete() throws Exception {
        int id = 2;
        PasswordRequirements passwordrequirements = restTemplate.getForObject(baseURL + "/passwordrequirements/" + id, PasswordRequirements.class);
        assertNotNull(passwordrequirements);
        restTemplate.delete(baseURL + "/passwordrequirements/" + id);
        try {
            passwordrequirements = restTemplate.getForObject(baseURL + "/passwordrequirements/" + id, PasswordRequirements.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() throws Exception {
        PasswordRequirements passwordRequirements = restTemplate.getForObject(baseURL + "/passwordrequirements/1", PasswordRequirements.class);
        System.out.println(passwordRequirements.getPasswordCharactherLenght());
        assertNotNull(passwordRequirements);
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