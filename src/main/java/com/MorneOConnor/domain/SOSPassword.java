package com.MorneOConnor.domain;

public class SOSPassword {
    private String oldSOSPassword;

    private SOSPassword() {
    }

    private SOSPassword(Builder builder) {
        this.oldSOSPassword = builder.oldSOSPassword;
    }

    public String getOldSOSPassword() {
        return oldSOSPassword;
    }

    public static class Builder {
        private String oldSOSPassword;

        public Builder oldSOSPassword(String oldSOSPassword) {
            this.oldSOSPassword = oldSOSPassword;
            return this;
        }

        public SOSPassword build() {
            return new SOSPassword(this);
        }
    }

}
