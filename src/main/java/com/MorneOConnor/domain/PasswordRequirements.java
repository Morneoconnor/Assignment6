package com.MorneOConnor.domain;

public class PasswordRequirements {
    private String passwordCharacther;
    private int passwordCharactherLenght;

    private PasswordRequirements() {
    }

    private PasswordRequirements(Builder builder) {
        this.passwordCharacther = builder.passwordCharacther;
        this.passwordCharactherLenght = builder.passwordCharactherLenght;
    }
    public String getPasswordCharacther() {
        return passwordCharacther;
    }

    public int getPasswordCharactherLenght() {
        return passwordCharactherLenght;
    }

    public static class Builder {
        private String passwordCharacther;
        private int passwordCharactherLenght;

        public Builder passwordCharacther(String passwordCharacther) {
            this.passwordCharacther = passwordCharacther;
            return this;
        }

        public Builder passwordCharactherLenght(int passwordCharactherLenght) {
            this.passwordCharactherLenght = passwordCharactherLenght;
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
