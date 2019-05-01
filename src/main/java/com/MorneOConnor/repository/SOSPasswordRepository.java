package com.MorneOConnor.repository;

import com.MorneOConnor.domain.SOSPassword;

import java.util.HashSet;
import java.util.Set;

public class SOSPasswordRepository {
    private static SOSPasswordRepository repository = null;
    private Set<SOSPassword> _sosPassword;

    private SOSPasswordRepository() {
        this._sosPassword = new HashSet<>();
    }

    public static SOSPasswordRepository getRepository() {
        if (repository == null) repository = new SOSPasswordRepository();
        return repository;
    }

    public SOSPassword create(SOSPassword sosPassword) {
        this._sosPassword.add(sosPassword);
        return sosPassword;
    }

    public SOSPassword read(String studentNumber) {
        if (_sosPassword.contains(studentNumber)) {
            for (SOSPassword obj : _sosPassword) {
                if (obj.equals(studentNumber))
                    return obj;
            }
        }
        return null;
    }

    public SOSPassword update(SOSPassword sosPassword) {
        for (SOSPassword i : _sosPassword)
            if (i.equals(sosPassword.getOldSOSPassword())) {
                _sosPassword.remove(i);
                _sosPassword.add(sosPassword);
                break;
            }

        return sosPassword;
    }

    public void delete(String studentNumber) {
        if (_sosPassword.contains(studentNumber)) {
            _sosPassword.remove(studentNumber);
        }
    }

    public Set<SOSPassword> getAll(){
        return this._sosPassword;
    }
}
