package com.MorneOConnor.domain;

public class StudentPersonalInformation {

    private String studentName, studentSurName, studentId, studentIdNumber, emailAddress;


    private StudentPersonalInformation() {
    }

    private StudentPersonalInformation(Builder builder) {
        this.studentName = builder.studentName;
        this.studentSurName = builder.studentSurName;
        this.studentId = builder.studentId;
        this.studentIdNumber = builder.studentIdNumber;
        this.emailAddress = builder.emailAddress;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurName() {
        return studentSurName;
    }

    public String getStudentId() {
        return studentId;
    }
    public String getStudentIdNumber() {
        return studentIdNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public static class Builder {
        private String studentName, studentSurName, studentId, studentIdNumber, emailAddress;

        public Builder studentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public Builder studentSurName(String studentSurName) {
            this.studentSurName = studentSurName;
            return this;
        }

        public Builder studentId(String studentId) {
            this.studentId = studentId;
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

