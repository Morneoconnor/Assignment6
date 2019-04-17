package com.MorneOConnor.factory;

import com.MorneOConnor.domain.CourseRegistration;

public class CourseRegistrationFactory {

        public static CourseRegistration createCourseRegistration (
            String courseName,int courseId)
        {
            return new CourseRegistration.Builder()
                    .courseName(courseName)
                    .courseId(courseId)
                    .build();
        }
}

