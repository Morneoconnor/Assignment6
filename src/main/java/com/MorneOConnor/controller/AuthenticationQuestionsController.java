package com.MorneOConnor.controller;
import com.MorneOConnor.domain.AuthenticationQuestions;
import com.MorneOConnor.service.AuthenticationQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

    @RestController
    @RequestMapping("/authenticationquestions")
    @Controller("AuthenticationQuestions")
    public class AuthenticationQuestionsController {
        @Autowired
        @Qualifier("AuthenticationQuestions")
        private AuthenticationQuestionService service;

        @PostMapping("/create")
        @ResponseBody
        public AuthenticationQuestions create(AuthenticationQuestions question) {
            return service.create(question);
        }

        @PostMapping("/update")
        @ResponseBody
        public AuthenticationQuestions update(AuthenticationQuestions question) {
            return service.update(question);
        }

        @GetMapping("/delete/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            service.delete(id);

        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public AuthenticationQuestions read(@PathVariable String id) {
            return service.read(id);
        }

        @GetMapping("/read/all")
        @ResponseBody
        public Set<AuthenticationQuestions> getAll() {
            return service.getAll();
        }

    }

