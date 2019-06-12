package com.MorneOConnor.controller;

import com.MorneOConnor.domain.SOSNewPassword;
import com.MorneOConnor.factory.SOSNewPasswordFactory;
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
public class SOSNewPasswordControllerTest {

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/sosnewpassword";

    @Test
    public void create() throws Exception {
        SOSNewPassword sosnewpassword =
                SOSNewPasswordFactory.createSOSNewPassword("Password123!", 1);

        ResponseEntity<SOSNewPassword> postResponse = restTemplate.postForEntity(baseURL + "/create", sosnewpassword, SOSNewPassword.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() throws Exception {
        int id = 1;
        SOSNewPassword sosnewpassword = restTemplate.getForObject(baseURL + "/sosnewpassword/" + id, SOSNewPassword.class);

        restTemplate.put(baseURL + "/sosnewpassword/" + id, sosnewpassword);
        SOSNewPassword updatedsosnewpassword = restTemplate.getForObject(baseURL + "/sosnewpassword/" + id, SOSNewPassword.class);
        assertNotNull(updatedsosnewpassword);
    }

    @Test
    public void delete() throws Exception {
        int id = 2;
        SOSNewPassword sosnewpassword = restTemplate.getForObject(baseURL + "/sosnewpassword/" + id, SOSNewPassword.class);
        assertNotNull(sosnewpassword);
        restTemplate.delete(baseURL + "/sosnewpassword/" + id);
        try {
            sosnewpassword = restTemplate.getForObject(baseURL + "/sosnewpassword/" + id, SOSNewPassword.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() throws Exception {
        SOSNewPassword sosNewPassword = restTemplate.getForObject(baseURL + "/sosnewpassword/1", SOSNewPassword.class);
        System.out.println(sosNewPassword.getNewSOSPassword());
        assertNotNull(sosNewPassword);
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