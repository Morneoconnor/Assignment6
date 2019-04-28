package com.MorneOConnor.repository;

import com.MorneOConnor.domain.BlackBoardNewPassword;

import java.util.HashSet;
import java.util.Set;

public class BlackBoardNewPasswordRepository {

    private static BlackBoardNewPasswordRepository repository = null;
    private Set<BlackBoardNewPassword> _blackBoardNewPassword;

    private BlackBoardNewPasswordRepository(){
        this._blackBoardNewPassword = new HashSet<>();
    }

    public static BlackBoardNewPasswordRepository getRepository(){
        if (repository == null) repository = new BlackBoardNewPasswordRepository();
        return repository;
    }


    public BlackBoardNewPassword create(BlackBoardNewPassword blackBoardNewPassword){
        this._blackBoardNewPassword.add(blackBoardNewPassword);
        return blackBoardNewPassword;
    }

    public BlackBoardNewPassword read(String studentNumber){
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String studentNumber) {
        // find the course, delete it if it exist
    }

    public BlackBoardNewPassword update(BlackBoardNewPassword blackBoardNewPassword){
        // find the course, update it and delete it if it exists
        return blackBoardNewPassword;
    }


    public Set<BlackBoardNewPassword> getAll(){
        return this._blackBoardNewPassword;
    }
}

