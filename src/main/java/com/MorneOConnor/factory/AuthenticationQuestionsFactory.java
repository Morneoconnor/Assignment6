package com.MorneOConnor.factory;

import com.MorneOConnor.domain.AuthenticationQuestions;

public class AuthenticationQuestionsFactory{

    public static AuthenticationQuestions createAuthenticationQuestions(
            String motherName, String fatherName, int id)
    {
        return new AuthenticationQuestions.Builder()
                .motherName(motherName)
                .fatherName(fatherName)
                .id(id)
                .build();
    }
}
