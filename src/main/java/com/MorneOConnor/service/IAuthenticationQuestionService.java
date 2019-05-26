package com.MorneOConnor.service;

import com.MorneOConnor.domain.AuthenticationQuestions;

import java.util.Set;

public interface IAuthenticationQuestionService extends IService<AuthenticationQuestions, String> {
    Set<AuthenticationQuestions> getAll();
}