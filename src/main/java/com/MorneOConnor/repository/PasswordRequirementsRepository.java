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

    public PasswordRequirements read(int passwordLength){
        if (_passwordRequirements.contains(passwordLength)) {
            for (PasswordRequirements obj : _passwordRequirements) {
                if (obj.equals(passwordLength))
                    return obj;
            }
        }

        return null;
    }

    public PasswordRequirements update(PasswordRequirements passwordRequirements){
        for(PasswordRequirements i : _passwordRequirements)
            if(i.equals(passwordRequirements.getPasswordCharacther())) {
                _passwordRequirements.remove(i);
                _passwordRequirements.add(passwordRequirements);
                break;
            }
        return passwordRequirements;
    }

    public void delete(int  passwordLength) {
        if(_passwordRequirements.contains(passwordLength))
        {
            _passwordRequirements.remove(passwordLength);
        }
    }

    public Set<PasswordRequirements> getAll(){
        return this._passwordRequirements;
    }
}
