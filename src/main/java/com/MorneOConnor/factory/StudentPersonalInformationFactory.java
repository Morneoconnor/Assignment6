package com.MorneOConnor.factory;

import com.MorneOConnor.domain.StudentPersonalInformation;

public class StudentPersonalInformationFactory {
    public static StudentPersonalInformation createStudentPersonalInformation (
            String studentName, String studentSurName, String studentNumber,
            String studentIdNumber, String emailAddress)
    {
        return new StudentPersonalInformation.Builder()
                .studentName(studentName)
                .studentSurName(studentSurName)
                .studentNumber(studentNumber)
                .studentIdNumber(studentIdNumber)
                .emailAddress(emailAddress)
                .build();
    }
}
