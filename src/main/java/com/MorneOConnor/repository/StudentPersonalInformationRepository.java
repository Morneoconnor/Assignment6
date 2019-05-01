package com.MorneOConnor.repository;

import com.MorneOConnor.domain.StudentPersonalInformation;

import java.util.HashSet;
import java.util.Set;

public class StudentPersonalInformationRepository {
    private static StudentPersonalInformationRepository repository = null;
    private Set<StudentPersonalInformation> _studentPersonalInformation;

    private StudentPersonalInformationRepository(){
        this._studentPersonalInformation = new HashSet<>();
    }

    public static StudentPersonalInformationRepository getRepository(){
        if (repository == null) repository = new StudentPersonalInformationRepository();
        return repository;
    }


    public StudentPersonalInformation create(StudentPersonalInformation studentPersonalInformation){
        this._studentPersonalInformation.add(studentPersonalInformation);
        return studentPersonalInformation;
    }

    public StudentPersonalInformation read(String studentNumber){
        if (_studentPersonalInformation.contains(studentNumber)) {
            for (StudentPersonalInformation obj : _studentPersonalInformation) {
                if (obj.equals(studentNumber))
                    return obj;
            }
        }

        return null;
    }

    public StudentPersonalInformation update(StudentPersonalInformation studentPersonalInformation){
        for(StudentPersonalInformation i : _studentPersonalInformation)
            if(i.equals(studentPersonalInformation.getClass())) {
                _studentPersonalInformation.remove(i);
                _studentPersonalInformation.add(studentPersonalInformation);
                break;
            }
        return studentPersonalInformation;
    }

    public void delete(String studentNumber) {
        if(_studentPersonalInformation.contains(studentNumber))
        {
            _studentPersonalInformation.remove(studentNumber);
        }
    }


    public Set<StudentPersonalInformation> getAll(){
        return this._studentPersonalInformation;
    }
}

