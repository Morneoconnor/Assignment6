package com.MorneOConnor.factory;

import com.MorneOConnor.domain.SOSPassword;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SOSPasswordFactoryTest {
    @Test
    public void createSOSPassword() {
        String name = "Password123";
        SOSPassword obj = SOSPasswordFactory.createSOSPassword
                (name);
        Assert.assertEquals("Password123",obj.getOldSOSPassword());
    }
}