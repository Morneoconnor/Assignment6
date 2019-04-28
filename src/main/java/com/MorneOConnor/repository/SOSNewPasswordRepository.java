package com.MorneOConnor.repository;

import com.MorneOConnor.domain.SOSNewPassword;

import java.util.HashSet;
import java.util.Set;

public class SOSNewPasswordRepository {
    private static SOSNewPasswordRepository repository = null;
    private Set<SOSNewPassword> _sosNewPassword;

    private SOSNewPasswordRepository(){
        this._sosNewPassword = new HashSet<>();
    }

    public static SOSNewPasswordRepository getRepository(){
        if (repository == null) repository = new SOSNewPasswordRepository();
        return repository;
    }


    public SOSNewPassword create(SOSNewPassword sosNewPassword){
        this._sosNewPassword.add(sosNewPassword);
        return sosNewPassword;
    }

    public SOSNewPassword read(String studentNumber){
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String studentNumber) {
        // find the course, delete it if it exist
    }

    public SOSNewPassword update(SOSNewPassword sosNewPassword){
        // find the course, update it and delete it if it exists
        return sosNewPassword;
    }


    public Set<SOSNewPassword> getAll(){
        return this._sosNewPassword;
    }
}
