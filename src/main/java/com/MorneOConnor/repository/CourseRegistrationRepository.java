package com.MorneOConnor.repository;

import com.MorneOConnor.domain.CourseRegistration;

import java.util.HashSet;
import java.util.Set;

public class CourseRegistrationRepository {
    private static CourseRegistrationRepository repository = null;
    private Set<CourseRegistration> _courseRegistration;

    private CourseRegistrationRepository(){
        this._courseRegistration = new HashSet<>();
    }

    public static CourseRegistrationRepository getRepository(){
        if (repository == null) repository = new CourseRegistrationRepository();
        return repository;
    }


    public CourseRegistration create(CourseRegistration courseRegistration){
        this._courseRegistration.add(courseRegistration);
        return courseRegistration;
    }

    public CourseRegistration read(String studentNumber){
        // find the course that matches the id and return it if exist
        return null;
    }

    public void delete(String studentNumber) {
        // find the course, delete it if it exist
    }

    public CourseRegistration update(CourseRegistration courseRegistration){
        // find the course, update it and delete it if it exists
        return courseRegistration;
    }


    public Set<CourseRegistration> getAll(){
        return this._courseRegistration;
    }
}
