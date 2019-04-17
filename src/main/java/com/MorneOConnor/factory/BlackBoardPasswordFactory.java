package com.MorneOConnor.factory;

import com.MorneOConnor.domain.BlackBoardPassword;

public class BlackBoardPasswordFactory {

        public static BlackBoardPassword createBlackBoardPassword(
            String oldBlackBoardPassword)
        {
            return new BlackBoardPassword.Builder()
                    .oldBlackBoardPassword(oldBlackBoardPassword)
                    .build();
        }
}

