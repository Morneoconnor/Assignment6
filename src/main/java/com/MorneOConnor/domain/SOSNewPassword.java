package com.MorneOConnor.domain;

public class SOSNewPassword {
    private String newSOSPassword;
    private int id;

    private SOSNewPassword() {
    }

    private SOSNewPassword(Builder builder) {
        this.newSOSPassword = builder.newSOSPassword;
        this.id = builder.id;
    }

    public String getNewSOSPassword() {
        return newSOSPassword;
    }
    public int getId() {
        return id;
    }

    public static class Builder {
        private String newSOSPassword;
        private int id;

        public Builder newSOSPassword(String newSOSPassword) {
            this.newSOSPassword = newSOSPassword;
            return this;
        }
        public Builder copy(SOSNewPassword password){
            this.newSOSPassword = password.newSOSPassword;

            return this;
        }
        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public SOSNewPassword build() {
            return new SOSNewPassword(this);
        }
    }

    public String toString() {
        return "SOS Password has been reset";
    }
}
