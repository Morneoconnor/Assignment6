package com.MorneOConnor.factory;

import com.MorneOConnor.domain.PasswordRequirements;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordRequirementsFactoryTest {
    @Test
    public void createPasswordRequirements() {
            String name = "Password123!";
            int id = 11;
            PasswordRequirements obj = PasswordRequirementsFactory.createPasswordRequirements
                    (name, id, 1);
            Assert.assertEquals("Password123",obj.getPasswordCharacther());
            Assert.assertEquals(11,obj.getPasswordCharactherLenght());
        }
    }

