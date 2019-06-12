package com.MorneOConnor.factory;

import com.MorneOConnor.domain.BlackBoardPassword;

public class BlackBoardPasswordFactory {

        public static BlackBoardPassword createBlackBoardPassword(
            String oldBlackBoardPassword, int id)
        {
            return new BlackBoardPassword.Builder()
                    .oldBlackBoardPassword(oldBlackBoardPassword)
                    .id(id)
                    .build();
        }
}

