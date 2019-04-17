package com.MorneOConnor.factory;
import com.MorneOConnor.domain.BlackBoardNewPassword;

public class BlackBoardNewPasswordFactory {

    public static BlackBoardNewPassword createBlackBoardNewPassword(
            String newBlackBoardPassword)
    {
        return new BlackBoardNewPassword.Builder()
                .newBlackBoardPassword(newBlackBoardPassword)
                .build();
    }
}
