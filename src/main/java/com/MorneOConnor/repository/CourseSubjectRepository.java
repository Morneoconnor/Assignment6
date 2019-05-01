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
        if (_courseSubject.contains(studentNumber)) {
            for (CourseSubjects obj : _courseSubject) {
                if (obj.equals(studentNumber))
                    return obj;
            }
        }
        return null;
    }

    public CourseSubjects update(CourseSubjects courseSubject){
        for(CourseSubjects i : _courseSubject)
            if(i.equals(courseSubject.getClass())) {
                _courseSubject.remove(i);
                _courseSubject.add(courseSubject);
                break;
            }
        return courseSubject;
    }

    public void delete(String studentNumber) {

        if(_courseSubject.contains(studentNumber))
        {
            _courseSubject.remove(studentNumber);
        }
    }

    public Set<CourseSubjects> getAll(){
        return this._courseSubject;
    }
}
