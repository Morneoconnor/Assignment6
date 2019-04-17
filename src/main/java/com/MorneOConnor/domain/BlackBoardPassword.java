package com.MorneOConnor.domain;

public class BlackBoardPassword {
    private String oldBlackBoardPassword;

    private BlackBoardPassword() {
    }

    private BlackBoardPassword(Builder builder) {
        this.oldBlackBoardPassword = builder.oldBlackBoardPassword;
    }

    public String getOldBlackBoardPassword() {
        return oldBlackBoardPassword;
    }

    public static class Builder {
        private String oldBlackBoardPassword;

        public Builder oldBlackBoardPassword(String oldBlackBoardPassword) {
            this.oldBlackBoardPassword = oldBlackBoardPassword;
            return this;
        }

        public BlackBoardPassword build() {
            return new BlackBoardPassword(this);
        }
    }

}
