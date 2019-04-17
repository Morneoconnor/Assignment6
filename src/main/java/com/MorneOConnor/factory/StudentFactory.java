package com.MorneOConnor.factory;

import com.MorneOConnor.domain.Student;

public class StudentFactory {

        public static Student createStudent (
            String studentName, String courseName, String studentId)
        {
            return new Student.Builder()
                    .studentName(studentName)
                    .courseName(courseName)
                    .studentId(studentId)
                    .build();
        }
}

