package com.MorneOConnor.controller;

import com.MorneOConnor.domain.CourseSubjects;
import com.MorneOConnor.service.CourseSubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

public class CourseSubjectsController {
    @Autowired
    @Qualifier("ServiceImpl")
    private CourseSubjectsService service;

    @PostMapping("/create")
    @ResponseBody
    public CourseSubjects create(CourseSubjects course) {
        return service.create(course);
    }

    @PostMapping("/update")
    @ResponseBody
    public CourseSubjects update(CourseSubjects course) {
        return service.update(course);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public CourseSubjects read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<CourseSubjects> getAll() {
        return service.getAll();
    }

}


