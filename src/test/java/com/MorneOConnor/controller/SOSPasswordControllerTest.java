package com.MorneOConnor.controller;

import com.MorneOConnor.domain.SOSPassword;
import com.MorneOConnor.factory.SOSPasswordFactory;
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
public class SOSPasswordControllerTest {

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/sospassword";

    @Test
    public void create() throws Exception {
        SOSPassword sospassword =
                SOSPasswordFactory.createSOSPassword("Password12", 1);

        ResponseEntity<SOSPassword> postResponse = restTemplate.postForEntity(baseURL + "/create", sospassword, SOSPassword.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() throws Exception {
        int id = 1;
        SOSPassword sospassword = restTemplate.getForObject(baseURL + "/sospassword/" + id, SOSPassword.class);

        restTemplate.put(baseURL + "/sospassword/" + id, sospassword);
        SOSPassword updatedsospassword = restTemplate.getForObject(baseURL + "/sospassword/" + id, SOSPassword.class);
        assertNotNull(updatedsospassword);
    }

    @Test
    public void delete() throws Exception {
        int id = 2;
        SOSPassword sospassword = restTemplate.getForObject(baseURL + "/sospassword/" + id, SOSPassword.class);
        assertNotNull(sospassword);
        restTemplate.delete(baseURL + "/sospassword/" + id);
        try {
            sospassword = restTemplate.getForObject(baseURL + "/sospassword/" + id, SOSPassword.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() throws Exception {
        SOSPassword sosPassword = restTemplate.getForObject(baseURL + "/sospassword/1", SOSPassword.class);
        System.out.println(sosPassword.getOldSOSPassword());
        assertNotNull(sosPassword);
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