package com.MorneOConnor.repository;

import com.MorneOConnor.domain.AuthenticationQuestions;

import java.util.HashSet;
import java.util.Set;

public class AuthenticationQuestionRepository implements IAuthenticationQuestionRepository {

    private static AuthenticationQuestionRepository repository = null;
    private Set<AuthenticationQuestions> _authenticationQuestions;

    private AuthenticationQuestionRepository(){
        this._authenticationQuestions = new HashSet<>();
    }

    public static AuthenticationQuestionRepository getRepository(){
        if (repository == null) repository = new AuthenticationQuestionRepository();
        return repository;
    }


    public AuthenticationQuestions create(AuthenticationQuestions authenticationQuestions){
        this._authenticationQuestions.add(authenticationQuestions);
        return authenticationQuestions;
    }

    public AuthenticationQuestions read(String studentNumber){
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String studentNumber) {
        // find the course, delete it if it exist
    }

    public AuthenticationQuestions update(AuthenticationQuestions authenticationQuestions){
        // find the course, update it and delete it if it exists
        return authenticationQuestions;
    }


    public Set<AuthenticationQuestions> getAll(){
        return this._authenticationQuestions;
    }
}
