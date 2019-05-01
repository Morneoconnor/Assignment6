package com.MorneOConnor.repository;

import com.MorneOConnor.domain.SOSNewPassword;
import com.MorneOConnor.factory.SOSNewPasswordFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class SOSNewPasswordRepositoryTest {
    private SOSNewPasswordRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = SOSNewPasswordRepository.getRepository();
    }

    @Test
    public void create() throws Exception {
        SOSNewPassword obj = SOSNewPasswordFactory.createSOSNewPassword
                ("PW1");

        this.repository.create(obj);
        Assert.assertEquals("PW1", obj.getNewSOSPassword());
    }

    @Test
    public void read() throws Exception {
        Object obj = this.repository.read("PW1");
        Assert.assertNull(obj);
    }

    @Test
    public void update() throws Exception {
        SOSNewPassword obj = SOSNewPasswordFactory.createSOSNewPassword
                ("PW1");

        Assert.assertEquals("PW1", obj.getNewSOSPassword());
    }

    @Test
    public void delete() throws Exception {
        boolean item = false;

        this.repository.delete("PW1");
        Set<SOSNewPassword> obj = this.repository.getAll();
        if(obj.contains("PW1"))
        {
            item = true;
        }
        else
            item = false;
        assertFalse(item);
    }
    @Test
    public void getAll() throws Exception {
        Set<SOSNewPassword> obj = this.repository.getAll();
        Assert.assertNotNull(obj);
    }

}