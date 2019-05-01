package com.MorneOConnor.factory;

import com.MorneOConnor.domain.Student;

public class StudentFactory {

        public static Student createStudent (
            String studentName, String courseName, String studentNumber)
        {
            return new Student.Builder()
                    .studentName(studentName)
                    .courseName(courseName)
                    .studentNumber(studentNumber)
                    .build();
        }
}

