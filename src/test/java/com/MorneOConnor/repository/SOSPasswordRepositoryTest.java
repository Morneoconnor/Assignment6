package com.MorneOConnor.repository;

import com.MorneOConnor.domain.SOSPassword;
import com.MorneOConnor.factory.SOSPasswordFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class SOSPasswordRepositoryTest {
    private SOSPasswordRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = SOSPasswordRepository.getRepository();
    }

    @Test
    public void create() throws Exception {
        SOSPassword obj = SOSPasswordFactory.createSOSPassword
                ("PW12");

        this.repository.create(obj);
        Assert.assertEquals("PW12", obj.getOldSOSPassword());
    }

    @Test
    public void read() throws Exception {
        Object obj = this.repository.read("PW12");
        Assert.assertNull(obj);
    }

    @Test
    public void update() throws Exception {
        SOSPassword obj = SOSPasswordFactory.createSOSPassword
                ("PW12");

        Assert.assertEquals("PW12", obj.getOldSOSPassword());
    }

    @Test
    public void delete() throws Exception {
        boolean item = false;

        this.repository.delete("PW12");
        Set<SOSPassword> obj = this.repository.getAll();
        if(obj.contains("PW12"))
        {
            item = true;
        }
        else
            item = false;
        assertFalse(item);
    }

    @Test
    public void getAll() throws Exception {
        Set<SOSPassword> obj = this.repository.getAll();
        Assert.assertNotNull(obj);
    }

}