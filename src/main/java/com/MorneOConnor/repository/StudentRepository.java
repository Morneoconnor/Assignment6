package com.MorneOConnor.repository;

import com.MorneOConnor.domain.Student;

import java.util.HashSet;
import java.util.Set;

public class StudentRepository implements IStudentRepository{
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
        if (_student.contains(studentNumber)) {
            for (Student obj : _student) {
                if (obj.equals(studentNumber))
                    return obj;
            }
        }
        return null;
    }

    public Student update(Student student){
        for(Student i : _student)
            if(i.equals(student.getClass())) {
                _student.remove(i);
                _student.add(student);
                break;
            }
        return student;
    }

    public void delete(String studentNumber) {
        if(_student.contains(studentNumber))
        {
            _student.remove(studentNumber);
        }
    }

    public Set<Student> getAll(){
        return this._student;
    }
}

