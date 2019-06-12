package com.MorneOConnor.repository;

import com.MorneOConnor.domain.AuthenticationQuestions;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("AuthenticationQuestion")
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
        if (_authenticationQuestions.contains(studentNumber)) {
            for (AuthenticationQuestions obj : _authenticationQuestions) {
                if (obj.equals(studentNumber))
                    return obj;
            }
        }
        return null;
    }

    public AuthenticationQuestions update(AuthenticationQuestions authenticationQuestions){
        for(AuthenticationQuestions i : _authenticationQuestions)
            if(i.equals(authenticationQuestions.getClass())) {
                _authenticationQuestions.remove(i);
                _authenticationQuestions.add(authenticationQuestions);
                break;
            }
        return authenticationQuestions;
    }

    public void delete(String studentNumber) {
        if(_authenticationQuestions.contains(studentNumber))
        {
            _authenticationQuestions.remove(studentNumber);
        }
    }

    public Set<AuthenticationQuestions> getAll(){
        return this._authenticationQuestions;
    }
}
