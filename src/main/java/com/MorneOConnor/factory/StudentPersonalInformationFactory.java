package com.MorneOConnor.factory;

import com.MorneOConnor.domain.StudentPersonalInformation;

public class StudentPersonalInformationFactory {
    public static StudentPersonalInformation createStudentPersonalInformation (
            String studentName, String studentSurName, String studentId,
            String studentIdNumber, String emailAddress)
    {
        return new StudentPersonalInformation.Builder()
                .studentName(studentName)
                .studentSurName(studentSurName)
                .studentId(studentId)
                .studentIdNumber(studentIdNumber)
                .emailAddress(emailAddress)
                .build();
    }
}
