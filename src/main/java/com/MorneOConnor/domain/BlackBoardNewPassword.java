package com.MorneOConnor.domain;

public class BlackBoardNewPassword {
    private String newBlackBoardPassword;

    private BlackBoardNewPassword() {
    }

    private BlackBoardNewPassword(Builder builder) {
        this.newBlackBoardPassword = builder.newBlackBoardPassword;
    }

    public String getNewBlackBoardPassword() {
        return newBlackBoardPassword;
    }

    public static class Builder {
        private String newBlackBoardPassword;

        public Builder newBlackBoardPassword(String newBlackBoardPassword) {
            this.newBlackBoardPassword = newBlackBoardPassword;
            return this;
        }

        public BlackBoardNewPassword build() {
            return new BlackBoardNewPassword(this);
        }
    }

    public String toString() {
        return "Blackboard Password has been reset";
    }
}
