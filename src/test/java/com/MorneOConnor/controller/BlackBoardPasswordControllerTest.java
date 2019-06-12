package com.MorneOConnor.controller;

import com.MorneOConnor.domain.BlackBoardPassword;
import com.MorneOConnor.factory.BlackBoardPasswordFactory;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BlackBoardPasswordControllerTest {

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/blackboardpassword";

    @Test
    public void create() throws Exception {
        BlackBoardPassword blackboardpassword =
                BlackBoardPasswordFactory.createBlackBoardPassword("Password12", 1);

        ResponseEntity<BlackBoardPassword> postResponse = restTemplate.postForEntity(baseURL + "/create", blackboardpassword, BlackBoardPassword.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() throws Exception {
        int id = 1;
        BlackBoardPassword blackboardpassword = restTemplate.getForObject(baseURL + "/blackboardpassword/" + id, BlackBoardPassword.class);

        restTemplate.put(baseURL + "/blackboardpassword/" + id, blackboardpassword);
        BlackBoardPassword updatedblackboardpassword = restTemplate.getForObject(baseURL + "/blackboardpassword/" + id, BlackBoardPassword.class);
        assertNotNull(updatedblackboardpassword);
    }

    @Test
    public void delete() throws Exception {

        int id = 2;
        BlackBoardPassword blackboardpassword = restTemplate.getForObject(baseURL + "/blackboardpassword/" + id, BlackBoardPassword.class);
        assertNotNull(blackboardpassword);
        restTemplate.delete(baseURL + "/blackboardpassword/" + id);
        try {
            blackboardpassword = restTemplate.getForObject(baseURL + "/blackboardpassword/" + id, BlackBoardPassword.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() throws Exception {
        BlackBoardPassword blackboardPassword = restTemplate.getForObject(baseURL + "/blackboardpassword/1", BlackBoardPassword.class);
        System.out.println(blackboardPassword.getOldBlackBoardPassword());
        assertNotNull(blackboardPassword);
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