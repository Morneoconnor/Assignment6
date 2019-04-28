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
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String studentNumber) {
        // find the course, delete it if it exist
    }

    public StudentPersonalInformation update(StudentPersonalInformation studentPersonalInformation){
        // find the course, update it and delete it if it exists
        return studentPersonalInformation;
    }


    public Set<StudentPersonalInformation> getAll(){
        return this._studentPersonalInformation;
    }
}

