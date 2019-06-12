package com.MorneOConnor.controller;

import com.MorneOConnor.domain.CourseSubjects;
import com.MorneOConnor.factory.CourseSubjectsFactory;
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
public class CourseSubjectsControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/coursesubjects";

    @Test
    public void create() throws Exception {
        CourseSubjects coursesubjects =
                CourseSubjectsFactory.createCourseRegistration("Prof Comm", 123);

        ResponseEntity<CourseSubjects> postResponse = restTemplate.postForEntity(baseURL + "/create", coursesubjects, CourseSubjects.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() throws Exception {
        int id = 1;
        CourseSubjects coursesubjects = restTemplate.getForObject(baseURL + "/coursesubjects/" + id, CourseSubjects.class);

        restTemplate.put(baseURL + "/coursesubjects/" + id, coursesubjects);
        CourseSubjects updatedcoursesubjects = restTemplate.getForObject(baseURL + "/coursesubjects/" + id, CourseSubjects.class);
        assertNotNull(updatedcoursesubjects);
    }

    @Test
    public void delete() throws Exception {
        int id = 2;
        CourseSubjects coursesubjects = restTemplate.getForObject(baseURL + "/coursesubjects/" + id, CourseSubjects.class);
        assertNotNull(coursesubjects);
        restTemplate.delete(baseURL + "/coursesubjects/" + id);
        try {
            coursesubjects = restTemplate.getForObject(baseURL + "/coursesubjects/" + id, CourseSubjects.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() throws Exception {
        CourseSubjects courseSubjects = restTemplate.getForObject(baseURL + "/courseregistration/1", CourseSubjects.class);
        System.out.println(courseSubjects.getSubjectName());
        assertNotNull(courseSubjects);
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