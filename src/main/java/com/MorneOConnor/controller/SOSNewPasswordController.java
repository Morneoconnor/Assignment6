package com.MorneOConnor.controller;

import com.MorneOConnor.domain.SOSNewPassword;
import com.MorneOConnor.service.SOSNewPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

public class SOSNewPasswordController {
    @Autowired
    @Qualifier("ServiceImpl")
    private SOSNewPasswordService service;

    @PostMapping("/create")
    @ResponseBody
    public SOSNewPassword create(SOSNewPassword password) {
        return service.create(password);
    }

    @PostMapping("/update")
    @ResponseBody
    public SOSNewPassword update(SOSNewPassword password) {
        return service.update(password);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public SOSNewPassword read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<SOSNewPassword> getAll() {
        return service.getAll();
    }

}

