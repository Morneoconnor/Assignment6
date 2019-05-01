package com.MorneOConnor.domain;

public class Student {
    private String studentName, courseName, studentNumber;

    private Student() {
    }

    private Student(Builder builder) {
        this.studentName = builder.studentName;
        this.courseName = builder.courseName;
        this.studentNumber = builder.studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public static class Builder {
        private String studentName, courseName, studentNumber;

        public Builder studentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public Builder courseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public Builder studentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
