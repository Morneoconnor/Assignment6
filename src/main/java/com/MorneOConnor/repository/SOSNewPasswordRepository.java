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
        if (_sosNewPassword.contains(studentNumber)) {
            for (SOSNewPassword obj : _sosNewPassword) {
                if (obj.equals(studentNumber))
                    return obj;
            }
        }
        return null;
    }

    public SOSNewPassword update(SOSNewPassword sosNewPassword){
        for(SOSNewPassword i : _sosNewPassword)
            if(i.equals(sosNewPassword.getNewSOSPassword())) {
                _sosNewPassword.remove(i);
                _sosNewPassword.add(sosNewPassword);
                break;
            }

        return sosNewPassword;
    }

    public void delete(String studentNumber) {
        if(_sosNewPassword.contains(studentNumber))
        {
            _sosNewPassword.remove(studentNumber);
        }
    }


    public Set<SOSNewPassword> getAll(){
        return this._sosNewPassword;
    }
}
