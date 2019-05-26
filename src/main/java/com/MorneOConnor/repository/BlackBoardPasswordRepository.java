package com.MorneOConnor.repository;

import com.MorneOConnor.domain.BlackBoardPassword;

import java.util.HashSet;
import java.util.Set;

public class BlackBoardPasswordRepository implements IBlackBoardPasswordRepository{
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

    public BlackBoardPassword read(String password){
        if (_blackBoardPassword.contains(password)) {
            for (BlackBoardPassword obj : _blackBoardPassword) {
                if (obj.equals(password))
                    return obj;
            }
        }
        return null;
    }

    public BlackBoardPassword update(BlackBoardPassword blackBoardPassword){
        for(BlackBoardPassword i : _blackBoardPassword)
            if(i.equals(blackBoardPassword.getClass())) {
                _blackBoardPassword.remove(i);
                _blackBoardPassword.add(blackBoardPassword);
                break;
            }
        return blackBoardPassword;
    }

    public void delete(String studentNumber) {
        if(_blackBoardPassword.contains(studentNumber))
        {
            _blackBoardPassword.remove(studentNumber);
        }
    }


    public Set<BlackBoardPassword> getAll(){
        return this._blackBoardPassword;
    }
}

