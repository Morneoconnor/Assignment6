package com.MorneOConnor.repository;

import com.MorneOConnor.domain.AuthenticationQuestions;

import java.util.Set;

public interface IAuthenticationQuestionRepository extends IRepository<AuthenticationQuestions, String> {
    Set<AuthenticationQuestions> getAll();
}