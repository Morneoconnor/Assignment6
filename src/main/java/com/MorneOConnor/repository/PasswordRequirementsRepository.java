package com.MorneOConnor.repository;

import com.MorneOConnor.domain.PasswordRequirements;

import java.util.HashSet;
import java.util.Set;

public class PasswordRequirementsRepository {
    private static PasswordRequirementsRepository repository = null;
    private Set<PasswordRequirements> _passwordRequirements;

    private PasswordRequirementsRepository(){
        this._passwordRequirements = new HashSet<>();
    }

    public static PasswordRequirementsRepository getRepository(){
        if (repository == null) repository = new PasswordRequirementsRepository();
        return repository;
    }


    public PasswordRequirements create(PasswordRequirements passwordRequirements){
        this._passwordRequirements.add(passwordRequirements);
        return passwordRequirements;
    }

    public PasswordRequirements read(String studentNumber){
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String studentNumber) {
        // find the course, delete it if it exist
    }

    public PasswordRequirements update(PasswordRequirements passwordRequirements){
        // find the course, update it and delete it if it exists
        return passwordRequirements;
    }


    public Set<PasswordRequirements> getAll(){
        return this._passwordRequirements;
    }
}
