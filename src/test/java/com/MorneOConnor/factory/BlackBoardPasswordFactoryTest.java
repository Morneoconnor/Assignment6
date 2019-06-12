package com.MorneOConnor.factory;

import com.MorneOConnor.domain.BlackBoardPassword;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackBoardPasswordFactoryTest {
    @Test
    public void createBlackBoardPassword(){
    String name = "Password";
    BlackBoardPassword obj = BlackBoardPasswordFactory.createBlackBoardPassword
            (name, 1);
        Assert.assertEquals("Password",obj.getOldBlackBoardPassword());
}
}