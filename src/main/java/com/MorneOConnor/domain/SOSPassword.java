package com.MorneOConnor.domain;

public class SOSPassword {
    private String oldSOSPassword;
    private int id;

    private SOSPassword() {
    }

    private SOSPassword(Builder builder) {
        this.oldSOSPassword = builder.oldSOSPassword;
        this.id = builder.id;
    }

    public String getOldSOSPassword() {
        return oldSOSPassword;
    }
    public int getId() {
        return id;
    }

    public static class Builder {
        private String oldSOSPassword;
        private int id;

        public Builder oldSOSPassword(String oldSOSPassword) {
            this.oldSOSPassword = oldSOSPassword;
            return this;
        }

        public Builder copy(SOSPassword password){
            this.oldSOSPassword = password.oldSOSPassword;

            return this;
        }
        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public SOSPassword build() {
            return new SOSPassword(this);
        }
    }

}
