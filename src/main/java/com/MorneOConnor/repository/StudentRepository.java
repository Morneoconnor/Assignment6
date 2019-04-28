package com.MorneOConnor.repository;

import com.MorneOConnor.domain.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentRepository {
    private static StudentRepository repository = null;
    private Set<Student> _student;

    private StudentRepository(){
        this._student = new HashSet<>();
    }

    public static StudentRepository getRepository(){
        if (repository == null) repository = new StudentRepository();
        return repository;
    }


    public Student create(Student student){
        this._student.add(student);
        return student;
    }

    public Student read(String studentNumber){
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String studentNumber) {
        // find the course, delete it if it exist
    }

    public Student update(Student student){
        // find the course, update it and delete it if it exists
        return student;
    }


    public Set<Student> getAll(){
        return this._student;
    }
}

