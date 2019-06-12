package com.MorneOConnor.controller;

import com.MorneOConnor.domain.SOSPassword;
import com.MorneOConnor.service.SOSPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

public class SOSPasswordController {
    @Autowired
    @Qualifier("ServiceImpl")
    private SOSPasswordService service;

    @PostMapping("/create")
    @ResponseBody
    public SOSPassword create(SOSPassword password) {
        return service.create(password);
    }

    @PostMapping("/update")
    @ResponseBody
    public SOSPassword update(SOSPassword password) {
        return service.update(password);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public SOSPassword read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<SOSPassword> getAll() {
        return service.getAll();
    }

}


