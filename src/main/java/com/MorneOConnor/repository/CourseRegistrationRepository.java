package com.MorneOConnor.repository;

import com.MorneOConnor.domain.CourseRegistration;

import java.util.HashSet;
import java.util.Set;

public class CourseRegistrationRepository implements ICourseRegistrationRepository{
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

    public CourseRegistration read(int id){
        if (_courseRegistration.contains(id)) {
            for (CourseRegistration obj : _courseRegistration) {
                if (obj.equals(id))
                    return obj;
            }
        }
        return null;
    }

    public CourseRegistration update(CourseRegistration courseRegistration){

        for(CourseRegistration i : _courseRegistration)
            if(i.equals(courseRegistration.getClass())) {
                _courseRegistration.remove(i);
                _courseRegistration.add(courseRegistration);
                break;
            }
        return courseRegistration;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public CourseRegistration read(String s) {
        return null;
    }

    public void delete(int id) {
        if(_courseRegistration.contains(id))
        {
            _courseRegistration.remove(id);
        }
    }

    public Set<CourseRegistration> getAll(){
        return this._courseRegistration;
    }
}
