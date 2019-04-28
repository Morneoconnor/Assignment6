package com.MorneOConnor.repository;

import com.MorneOConnor.domain.BlackBoardPassword;

import java.util.HashSet;
import java.util.Set;

public class BlackBoardPasswordRepository {
    private static BlackBoardPasswordRepository repository = null;
    private Set<BlackBoardPassword> _blackBoardPassword;

    private BlackBoardPasswordRepository(){
        this._blackBoardPassword = new HashSet<>();
    }

    public static BlackBoardPasswordRepository getRepository(){
        if (repository == null) repository = new BlackBoardPasswordRepository();
        return repository;
    }


    public BlackBoardPassword create(BlackBoardPassword blackBoardPassword){
        this._blackBoardPassword.add(blackBoardPassword);
        return blackBoardPassword;
    }

    public BlackBoardPassword read(String studentNumber){
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String studentNumber) {
        // find the course, delete it if it exist
    }

    public BlackBoardPassword update(BlackBoardPassword blackBoardNewPassword){
        // find the course, update it and delete it if it exists
        return blackBoardNewPassword;
    }


    public Set<BlackBoardPassword> getAll(){
        return this._blackBoardPassword;
    }
}

