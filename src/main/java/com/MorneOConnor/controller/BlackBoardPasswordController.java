package com.MorneOConnor.controller;

import com.MorneOConnor.domain.BlackBoardPassword;
import com.MorneOConnor.service.BlackBoardPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

public class BlackBoardPasswordController {
    @Autowired
    @Qualifier("ServiceImpl")
    private BlackBoardPasswordService service;

    @PostMapping("/create")
    @ResponseBody
    public BlackBoardPassword create(BlackBoardPassword password) {
        return service.create(password);
    }

    @PostMapping("/update")
    @ResponseBody
    public BlackBoardPassword update(BlackBoardPassword password) {
        return service.update(password);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public BlackBoardPassword read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<BlackBoardPassword> getAll() {
        return service.getAll();
    }

}

