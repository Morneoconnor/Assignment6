package com.MorneOConnor.controller;

import com.MorneOConnor.domain.CourseRegistration;
import com.MorneOConnor.factory.CourseRegistrationFactory;
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
public class CourseRegistrationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/courseregistration";

    @Test
    public void create() throws Exception {
        CourseRegistration courseregistration =
                CourseRegistrationFactory.createCourseRegistration("App Dev", 123);

        ResponseEntity<CourseRegistration> postResponse = restTemplate.postForEntity(baseURL + "/create", courseregistration, CourseRegistration.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() throws Exception {
        int id = 1;
        CourseRegistration courseregistration = restTemplate.getForObject(baseURL + "/courseregistration/" + id, CourseRegistration.class);

        restTemplate.put(baseURL + "/courseregistration/" + id, courseregistration);
        CourseRegistration updatedcourseregistration = restTemplate.getForObject(baseURL + "/courseregistration/" + id, CourseRegistration.class);
        assertNotNull(updatedcourseregistration);
    }

    @Test
    public void delete() throws Exception {
        int id = 2;
        CourseRegistration courseregistration = restTemplate.getForObject(baseURL + "/courseregistration/" + id, CourseRegistration.class);
        assertNotNull(courseregistration);
        restTemplate.delete(baseURL + "/courseregistration/" + id);
        try {
            courseregistration = restTemplate.getForObject(baseURL + "/courseregistration/" + id, CourseRegistration.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() throws Exception {
        CourseRegistration courseRegistration = restTemplate.getForObject(baseURL + "/courseregistration/1", CourseRegistration.class);
        System.out.println(courseRegistration.getCourseName());
        assertNotNull(courseRegistration);
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