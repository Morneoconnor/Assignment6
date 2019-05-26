package com.MorneOConnor.repository;

import com.MorneOConnor.domain.BlackBoardNewPassword;

import java.util.HashSet;
import java.util.Set;

public class BlackBoardNewPasswordRepository implements IBlackBoardNewPasswordRepository{

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
        if (_blackBoardNewPassword.contains(studentNumber)) {
            for (BlackBoardNewPassword obj : _blackBoardNewPassword) {
                if (obj.equals(studentNumber))
                    return obj;
            }
        }
        return null;
    }

    public BlackBoardNewPassword update(BlackBoardNewPassword blackBoardNewPassword){

        for(BlackBoardNewPassword i : _blackBoardNewPassword)
            if(i.equals(blackBoardNewPassword.getClass())) {
                _blackBoardNewPassword.remove(i);
                _blackBoardNewPassword.add(blackBoardNewPassword);
                break;
            }

        return blackBoardNewPassword;
    }

    public void delete(String studentNumber) {
        if(_blackBoardNewPassword.contains(studentNumber))
        {
            _blackBoardNewPassword.remove(studentNumber);
        }
    }
    public Set<BlackBoardNewPassword> getAll(){
        return this._blackBoardNewPassword;
    }
}

