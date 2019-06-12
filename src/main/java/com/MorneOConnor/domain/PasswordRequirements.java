package com.MorneOConnor.domain;

public class PasswordRequirements {
    private String passwordCharacther;
    private int passwordCharactherLenght;
    private int id;

    private PasswordRequirements() {
    }

    private PasswordRequirements(Builder builder) {
        this.passwordCharacther = builder.passwordCharacther;
        this.passwordCharactherLenght = builder.passwordCharactherLenght;
        this.id = builder.id;
    }
    public String getPasswordCharacther() {
        return passwordCharacther;
    }

    public int getPasswordCharactherLenght() {
        return passwordCharactherLenght;
    }
    public int getId() {
        return id;
    }

    public static class Builder {
        private String passwordCharacther;
        private int passwordCharactherLenght;
        private int id;

        public Builder passwordCharacther(String passwordCharacther) {
            this.passwordCharacther = passwordCharacther;
            return this;
        }

        public Builder passwordCharactherLenght(int passwordCharactherLenght) {
            this.passwordCharactherLenght = passwordCharactherLenght;
            return this;
        }
        public Builder copy(PasswordRequirements requirements){
            this.passwordCharactherLenght = requirements.passwordCharactherLenght;
            this.passwordCharacther = requirements.passwordCharacther;

            return this;
        }
        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public PasswordRequirements build() {
            return new PasswordRequirements(this);
        }
    }
    public String toString() {
        return "Password meets requirements";
    }
}
