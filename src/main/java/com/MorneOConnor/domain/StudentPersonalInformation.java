package com.MorneOConnor.domain;

public class StudentPersonalInformation {

    private String studentName, studentSurName, studentNumber, studentIdNumber, emailAddress;


    private StudentPersonalInformation() {
    }

    private StudentPersonalInformation(Builder builder) {
        this.studentName = builder.studentName;
        this.studentSurName = builder.studentSurName;
        this.studentNumber = builder.studentNumber;
        this.studentIdNumber = builder.studentIdNumber;
        this.emailAddress = builder.emailAddress;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurName() {
        return studentSurName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
    public String getStudentIdNumber() {
        return studentIdNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public static class Builder {
        private String studentName, studentSurName, studentNumber, studentIdNumber, emailAddress;

        public Builder studentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public Builder studentSurName(String studentSurName) {
            this.studentSurName = studentSurName;
            return this;
        }

        public Builder studentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }
        public Builder studentIdNumber(String studentIdNumber) {
            this.studentIdNumber = studentIdNumber;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public StudentPersonalInformation build() {
            return new StudentPersonalInformation(this);
        }
    }
}

