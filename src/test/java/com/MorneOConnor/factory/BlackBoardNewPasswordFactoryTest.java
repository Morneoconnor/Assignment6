package com.MorneOConnor.factory;

import com.MorneOConnor.domain.BlackBoardNewPassword;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackBoardNewPasswordFactoryTest {
    @Test
    public void createBlackBoardNewPassword() {
        String name = "Password123";
        BlackBoardNewPassword obj = BlackBoardNewPasswordFactory.createBlackBoardNewPassword
                (name, 1);
        Assert.assertEquals("Password123",obj.getNewBlackBoardPassword());
    }
}
