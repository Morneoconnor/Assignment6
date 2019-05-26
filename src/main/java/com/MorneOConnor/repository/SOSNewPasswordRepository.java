package com.MorneOConnor.repository;

import com.MorneOConnor.domain.SOSNewPassword;

import java.util.HashSet;
import java.util.Set;

public class SOSNewPasswordRepository implements ISOSNewPasswordRepository{
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

    public SOSNewPassword read(String password){
        if (_sosNewPassword.contains(password)) {
            for (SOSNewPassword obj : _sosNewPassword) {
                if (obj.equals(password))
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

    public void delete(String password) {
        if(_sosNewPassword.contains(password))
        {
            _sosNewPassword.remove(password);
        }
    }


    public Set<SOSNewPassword> getAll(){
        return this._sosNewPassword;
    }
}
