package com.MorneOConnor.controller;

import com.MorneOConnor.domain.Student;
import com.MorneOConnor.factory.StudentFactory;
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
public class StudentControllerTest {

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/student";

    @Test
    public void create() throws Exception {
        Student student =
                StudentFactory.createStudent("Morne","App Dev","123");

        ResponseEntity<Student> postResponse = restTemplate.postForEntity(baseURL + "/create", student, Student.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() throws Exception {
        int id = 1;
        Student student = restTemplate.getForObject(baseURL + "/student/" + id, Student.class);

        restTemplate.put(baseURL + "/student/" + id, student);
        Student updatedStudent = restTemplate.getForObject(baseURL + "/Student/" + id, Student.class);
        assertNotNull(updatedStudent);
    }

    @Test
    public void delete() throws Exception {
        int id = 2;
        Student student = restTemplate.getForObject(baseURL + "/student/" + id, Student.class);
        assertNotNull(student);
        restTemplate.delete(baseURL + "/student/" + id);
        try {
            student = restTemplate.getForObject(baseURL + "/student/" + id, Student.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() throws Exception {
        Student student = restTemplate.getForObject(baseURL + "/student/1", Student.class);
        System.out.println(student.getCourseName());
        assertNotNull(student);
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