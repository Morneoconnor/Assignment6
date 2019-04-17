package com.MorneOConnor.domain;

public class SOSNewPassword {
    private String newSOSPassword;

    private SOSNewPassword() {
    }

    private SOSNewPassword(Builder builder) {
        this.newSOSPassword = builder.newSOSPassword;
    }

    public String getNewSOSPassword() {
        return newSOSPassword;
    }

    public static class Builder {
        private String newSOSPassword;

        public Builder newSOSPassword(String newSOSPassword) {
            this.newSOSPassword = newSOSPassword;
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
