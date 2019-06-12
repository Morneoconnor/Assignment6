package com.MorneOConnor.domain;

public class CourseSubjects {
    private String subjectName;
    private int subjectId;

    private CourseSubjects() {
    }

    private CourseSubjects(Builder builder) {
        this.subjectName = builder.subjectName;
        this.subjectId = builder.subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public static class Builder {
        private String subjectName;
        private int subjectId;

        public Builder subjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public Builder subjectId(int subjectId) {
            this.subjectId = subjectId;
            return this;
        }
        public Builder copy(CourseSubjects course){
            this.subjectId = course.subjectId;
            this.subjectName = course.subjectName;

            return this;
        }

        public CourseSubjects build() {
            return new CourseSubjects(this);
        }
    }
}

