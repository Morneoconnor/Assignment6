package com.MorneOConnor.controller;

import com.MorneOConnor.domain.StudentPersonalInformation;
import com.MorneOConnor.factory.StudentPersonalInformationFactory;
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
public class StudentPersonalInformationControllerTest {

    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/studentpersonalinformation";

    @Test
    public void create() throws Exception {
        StudentPersonalInformation studentpersonalinformation =
                StudentPersonalInformationFactory.createStudentPersonalInformation
                        ("Morne","OConnor","123","123","morne@test.com");

        ResponseEntity<StudentPersonalInformation> postResponse = restTemplate.postForEntity(baseURL + "/create", studentpersonalinformation, StudentPersonalInformation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() throws Exception {
        int id = 1;
        StudentPersonalInformation studentpersonalinformation = restTemplate.getForObject(baseURL + "/studentpersonalinformation/" + id, StudentPersonalInformation.class);

        restTemplate.put(baseURL + "/studentpersonalinformation/" + id, studentpersonalinformation);
        StudentPersonalInformation updatedstudentpersonalinformation = restTemplate.getForObject(baseURL + "/studentpersonalinformation/" + id, StudentPersonalInformation.class);
        assertNotNull(updatedstudentpersonalinformation);
    }

    @Test
    public void delete() throws Exception {
        int id = 2;
        StudentPersonalInformation studentpersonalinformation = restTemplate.getForObject(baseURL + "/studentpersonalinformation/" + id, StudentPersonalInformation.class);
        assertNotNull(studentpersonalinformation);
        restTemplate.delete(baseURL + "/studentpersonalinformation/" + id);
        try {
            studentpersonalinformation = restTemplate.getForObject(baseURL + "/studentpersonalinformation/" + id, StudentPersonalInformation.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() throws Exception {
        StudentPersonalInformation studentpersonalinformation = restTemplate.getForObject(baseURL + "/studentpersonalinformation/1", StudentPersonalInformation.class);
        System.out.println(studentpersonalinformation.getEmailAddress());
        assertNotNull(studentpersonalinformation);
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