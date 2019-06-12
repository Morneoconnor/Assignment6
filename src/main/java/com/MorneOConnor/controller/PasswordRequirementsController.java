package com.MorneOConnor.controller;

import com.MorneOConnor.domain.PasswordRequirements;
import com.MorneOConnor.service.PasswordRequirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

public class PasswordRequirementsController {
    @Autowired
    @Qualifier("ServiceImpl")
    private PasswordRequirementsService service;

    @PostMapping("/create")
    @ResponseBody
    public PasswordRequirements create(PasswordRequirements requirements) {
        return service.create(requirements);
    }

    @PostMapping("/update")
    @ResponseBody
    public PasswordRequirements update(PasswordRequirements requirements) {
        return service.update(requirements);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public PasswordRequirements read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<PasswordRequirements> getAll() {
        return service.getAll();
    }

}
