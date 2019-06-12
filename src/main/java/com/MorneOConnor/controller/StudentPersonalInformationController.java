package com.MorneOConnor.controller;

import com.MorneOConnor.domain.StudentPersonalInformation;
import com.MorneOConnor.service.StudentPersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

public class StudentPersonalInformationController {
    @Autowired
    @Qualifier("ServiceImpl")
    private StudentPersonalInformationService service;

    @PostMapping("/create")
    @ResponseBody
    public StudentPersonalInformation create(StudentPersonalInformation information) {
        return service.create(information);
    }

    @PostMapping("/update")
    @ResponseBody
    public StudentPersonalInformation update(StudentPersonalInformation information) {
        return service.update(information);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public StudentPersonalInformation read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<StudentPersonalInformation> getAll() {
        return service.getAll();
    }

}


