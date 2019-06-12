package com.MorneOConnor.controller;

import com.MorneOConnor.domain.BlackBoardNewPassword;
import com.MorneOConnor.service.BlackBoardNewPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

public class BlackBoardNewPasswordController {
    @Autowired
    @Qualifier("ServiceImpl")
    private BlackBoardNewPasswordService service;

    @PostMapping("/create")
    @ResponseBody
    public BlackBoardNewPassword create(BlackBoardNewPassword password) {
        return service.create(password);
    }

    @PostMapping("/update")
    @ResponseBody
    public BlackBoardNewPassword update(BlackBoardNewPassword password) {
        return service.update(password);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public BlackBoardNewPassword read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<BlackBoardNewPassword> getAll() {
        return service.getAll();
    }

}
