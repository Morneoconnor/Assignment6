package com.MorneOConnor.domain;

public class AuthenticationQuestions {

    private String motherName, fatherName;
    private int id;

    private AuthenticationQuestions() {
    }

    private AuthenticationQuestions(Builder builder) {
        this.motherName = builder.motherName;
        this.fatherName = builder.fatherName;
        this.id = builder.id;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public int getId() {
        return id;
    }

    public static class Builder {
        private String motherName, fatherName;
        private int id;

        public Builder motherName(String motherName) {
            this.motherName = motherName;
            return this;
        }

        public Builder fatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }
        public Builder copy(AuthenticationQuestions questions){
            this.motherName = questions.motherName;
            this.fatherName = questions.fatherName;
            this.id = questions.id;

            return this;
        }

        public AuthenticationQuestions build() {
            return new AuthenticationQuestions(this);
        }
    }

    public String toString() {
        return "Confirm your answers{" +
                "Mothers name: " + motherName +
                "Fathers name: " + fatherName +
                "Student Id: " + id +
                '}';
    }
}