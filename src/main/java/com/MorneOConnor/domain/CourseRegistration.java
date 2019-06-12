package com.MorneOConnor.domain;

public class CourseRegistration {

    private String courseName;
    private int courseId;

    private CourseRegistration() {
    }

    private CourseRegistration(Builder builder) {
        this.courseName = builder.courseName;
        this.courseId = builder.courseId;
    }

    public String getCourseName() {
        return courseName;
    }
    public int getCourseId() {
        return courseId;
    }

    public static class Builder {
        private String courseName;
        private int courseId;

        public Builder courseName(String courseName) {
            this.courseName = courseName;
            return this;
        }
        public Builder courseId(int courseId){
            this.courseId = courseId;
            return this;
        }
        public Builder copy(CourseRegistration course){
            this.courseId = course.courseId;
            this.courseName = course.courseName;

            return this;
        }

        public CourseRegistration build() {
            return new CourseRegistration(this);
        }
    }

    public String toString() {
        return "Course you are registered for is{" +
                "Course Name: " + courseName +
                "Course Id: " + courseId +
                '}';
    }
}
