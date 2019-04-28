package com.MorneOConnor.repository;

import com.MorneOConnor.domain.SOSPassword;

import java.util.HashSet;
import java.util.Set;

public class SOSPasswordRepository {
    private static SOSPasswordRepository repository = null;
    private Set<SOSPassword> _sosPassword;

    private SOSPasswordRepository(){
        this._sosPassword = new HashSet<>();
    }

    public static SOSPasswordRepository getRepository(){
        if (repository == null) repository = new SOSPasswordRepository();
        return repository;
    }


    public SOSPassword create(SOSPassword sosPassword){
        this._sosPassword.add(sosPassword);
        return sosPassword;
    }

    public SOSPassword read(String studentNumber){
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String studentNumber) {
        // find the course, delete it if it exist
    }

    public SOSPassword update(SOSPassword sosPassword){
        // find the course, update it and delete it if it exists
        return sosPassword;
    }


    public Set<SOSPassword> getAll(){
        return this._sosPassword;
    }
}
