package com.MorneOConnor.repository;

import com.MorneOConnor.domain.CourseSubjects;

import java.util.HashSet;
import java.util.Set;

public class CourseSubjectRepository implements ICourseSubjectRepository{
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

    public CourseSubjects read(int subjectId){
        if (_courseSubject.contains(subjectId)) {
            for (CourseSubjects obj : _courseSubject) {
                if (obj.equals(subjectId))
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

    @Override
    public void delete(String s) {

    }

    @Override
    public CourseSubjects read(String s) {
        return null;
    }

    public void delete(int studentId) {

        if(_courseSubject.contains(studentId))
        {
            _courseSubject.remove(studentId);
        }
    }

    public Set<CourseSubjects> getAll(){
        return this._courseSubject;
    }
}
