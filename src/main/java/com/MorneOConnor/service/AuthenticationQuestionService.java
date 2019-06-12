package com.MorneOConnor.service;

import com.MorneOConnor.domain.AuthenticationQuestions;
import com.MorneOConnor.repository.AuthenticationQuestionRepository;
import com.MorneOConnor.repository.IAuthenticationQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AuthenticationQuestions")
    public class AuthenticationQuestionService implements IAuthenticationQuestionService
    {

        private static AuthenticationQuestionService service = null;
        private IAuthenticationQuestionRepository repository;

        private AuthenticationQuestionService() {
            this.repository = AuthenticationQuestionRepository.getRepository();
        }

        public static AuthenticationQuestionService getService(){
            if (service == null) service = new AuthenticationQuestionService();
            return service;
        }

        @Override
        public AuthenticationQuestions create(AuthenticationQuestions questions) {
            return this.repository.create(questions);
        }

        @Override
        public AuthenticationQuestions update(AuthenticationQuestions questions) {
            return this.repository.update(questions);
        }

        @Override
        public void delete(String s) {
            this.repository.delete(s);
        }

        @Override
        public AuthenticationQuestions read(String s) {
            return this.repository.read(s);
        }

        @Override
        public Set<AuthenticationQuestions> getAll() {
            return this.repository.getAll();
        }
    }


