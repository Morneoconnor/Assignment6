package com.MorneOConnor.factory;

import com.MorneOConnor.domain.SOSNewPassword;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SOSNewPasswordFactoryTest {
    @Test
    public void createSOSNewPassword(){
        String name = "Password";
        int id = 11;
        SOSNewPassword obj = SOSNewPasswordFactory.createSOSNewPassword
                (name);
        Assert.assertEquals("Password",obj.getNewSOSPassword());
    }
}