package com.MorneOConnor.domain;

public class Student {
    private String studentName, courseName, studentId;

    private Student() {
    }

    private Student(Builder builder) {
        this.studentName = builder.studentName;
        this.courseName = builder.courseName;
        this.studentId = builder.studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStudentId() {
        return studentId;
    }

    public static class Builder {
        private String studentName, courseName, studentId;

        public Builder studentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public Builder courseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
