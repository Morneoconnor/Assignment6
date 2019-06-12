package com.MorneOConnor.controller;

import com.MorneOConnor.domain.BlackBoardNewPassword;
import com.MorneOConnor.factory.BlackBoardNewPasswordFactory;
import com.MorneOConnor.factory.BlackBoardPasswordFactory;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class BlackBoardNewPasswordControllerTest {

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/blackboardnewpassword";
    @Test
    public void create() throws Exception {
        BlackBoardNewPassword blackboardnewpassword =
                BlackBoardNewPasswordFactory.createBlackBoardNewPassword("Password123", 1);

        ResponseEntity<BlackBoardNewPassword> postResponse = restTemplate.postForEntity(baseURL + "/create", blackboardnewpassword, BlackBoardNewPassword.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() throws Exception {
        int id = 1;
        BlackBoardNewPassword blackboardnewpassword = restTemplate.getForObject(baseURL + "/blackboardnewpassword/" + id, BlackBoardNewPassword.class);

        restTemplate.put(baseURL + "/blackboardnewpassword/" + id, blackboardnewpassword);
        BlackBoardNewPassword updatedblackboardnewpassword = restTemplate.getForObject(baseURL + "/blackboardnewpassword/" + id, BlackBoardNewPassword.class);
        assertNotNull(updatedblackboardnewpassword);
    }

    @Test
    public void delete() throws Exception {

        int id = 2;
        BlackBoardNewPassword blackboardnewpassword = restTemplate.getForObject(baseURL + "/blackboardnewpassword/" + id, BlackBoardNewPassword.class);
        assertNotNull(blackboardnewpassword);
        restTemplate.delete(baseURL + "/blackboardnewpassword/" + id);
        try {
            blackboardnewpassword = restTemplate.getForObject(baseURL + "/blackboardnewpassword/" + id, BlackBoardNewPassword.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() throws Exception {
        BlackBoardNewPassword blackboardNewPassword = restTemplate.getForObject(baseURL + "/blackboardnewpassword/1", BlackBoardNewPassword.class);
        System.out.println(blackboardNewPassword.getNewBlackBoardPassword());
        assertNotNull(blackboardNewPassword);
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