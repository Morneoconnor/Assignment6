package com.MorneOConnor.domain;

public class BlackBoardPassword {
    private String oldBlackBoardPassword;
    private int id;

    private BlackBoardPassword() {
    }

    private BlackBoardPassword(Builder builder) {
        this.oldBlackBoardPassword = builder.oldBlackBoardPassword;
        this.id = builder.id;
    }

    public String getOldBlackBoardPassword() {
        return oldBlackBoardPassword;
    }
    public int getId() {
        return id;
    }

    public static class Builder {
        private String oldBlackBoardPassword;
        private int id;

        public Builder oldBlackBoardPassword(String oldBlackBoardPassword) {
            this.oldBlackBoardPassword = oldBlackBoardPassword;
            return this;
        }
        public Builder copy(BlackBoardPassword password){
            this.oldBlackBoardPassword = password.oldBlackBoardPassword;

            return this;
        }
        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public BlackBoardPassword build() {
            return new BlackBoardPassword(this);
        }
    }

}
