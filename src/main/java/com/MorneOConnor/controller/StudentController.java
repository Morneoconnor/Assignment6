package com.MorneOConnor.controller;

import com.MorneOConnor.domain.Student;
import com.MorneOConnor.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

public class StudentController {
    @Autowired
    @Qualifier("ServiceImpl")
    private StudentService service;

    @PostMapping("/create")
    @ResponseBody
    public Student create(Student information) {
        return service.create(information);
    }

    @PostMapping("/update")
    @ResponseBody
    public Student update(Student information) {
        return service.update(information);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Student read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Student> getAll() {
        return service.getAll();
    }

}



