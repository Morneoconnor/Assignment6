package com.MorneOConnor.domain;

public class BlackBoardNewPassword {
    private String newBlackBoardPassword;
    private int id;

    private BlackBoardNewPassword() {
    }

    private BlackBoardNewPassword(Builder builder) {
        this.newBlackBoardPassword = builder.newBlackBoardPassword;
        this.id = builder.id;
    }

    public String getNewBlackBoardPassword() {
        return newBlackBoardPassword;
    }
    public int getId() {
        return id;
    }

    public static class Builder {
        private String newBlackBoardPassword;
        private int id;

        public Builder newBlackBoardPassword(String newBlackBoardPassword) {
            this.newBlackBoardPassword = newBlackBoardPassword;
            return this;
        }
        public Builder copy(BlackBoardNewPassword password){
            this.newBlackBoardPassword = password.newBlackBoardPassword;
            this.id = password.id;

            return this;
        }
        public Builder id(int id) {
            this.id = id;
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
