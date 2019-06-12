package com.MorneOConnor.factory;

import com.MorneOConnor.domain.AuthenticationQuestions;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthenticationQuestionsFactoryTest {

        @Test
        public  void createAuthenticationQuestions() {
            String name = "Renette";
            AuthenticationQuestions obj = AuthenticationQuestionsFactory.createAuthenticationQuestions
                    ("Renette", "Chris" ,1);
            Assert.assertEquals("Chris",obj.getFatherName());
        }
}

