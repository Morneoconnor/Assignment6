package com.MorneOConnor.factory;

import com.MorneOConnor.domain.CourseSubjects;

public class CourseSubjectsFactory {
    public static CourseSubjects createCourseRegistration (
            String subjectName,int subjectId)
    {
        return new CourseSubjects.Builder()
                .subjectName(subjectName)
                .subjectId(subjectId)
                .build();
    }
}
