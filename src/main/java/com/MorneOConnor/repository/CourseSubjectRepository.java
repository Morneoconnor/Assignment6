package com.MorneOConnor.repository;

import com.MorneOConnor.domain.CourseSubjects;

import java.util.HashSet;
import java.util.Set;

public class CourseSubjectRepository {
    private static CourseSubjectRepository repository = null;
    private Set<CourseSubjects> _courseSubject;

    private CourseSubjectRepository(){
        this._courseSubject = new HashSet<>();
    }

    public static CourseSubjectRepository getRepository(){
        if (repository == null) repository = new CourseSubjectRepository();
        return repository;
    }


    public CourseSubjects create(CourseSubjects courseSubject){
        this._courseSubject.add(courseSubject);
        return courseSubject;
    }

    public CourseSubjects read(String studentNumber){
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String studentNumber) {
        // find the course, delete it if it exist
    }

    public CourseSubjects update(CourseSubjects courseSubject){
        // find the course, update it and delete it if it exists
        return courseSubject;
    }


    public Set<CourseSubjects> getAll(){
        return this._courseSubject;
    }
}
