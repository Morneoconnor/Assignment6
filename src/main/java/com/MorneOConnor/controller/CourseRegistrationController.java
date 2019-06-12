package com.MorneOConnor.controller;

import com.MorneOConnor.domain.CourseRegistration;
import com.MorneOConnor.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

public class CourseRegistrationController {
    @Autowired
    @Qualifier("ServiceImpl")
    private CourseRegistrationService service;

    @PostMapping("/create")
    @ResponseBody
    public CourseRegistration create(CourseRegistration course) {
        return service.create(course);
    }

    @PostMapping("/update")
    @ResponseBody
    public CourseRegistration update(CourseRegistration course) {
        return service.update(course);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public CourseRegistration read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<CourseRegistration> getAll() {
        return service.getAll();
    }

}

