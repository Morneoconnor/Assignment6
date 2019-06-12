package com.MorneOConnor.service;

import com.MorneOConnor.domain.SOSPassword;
import com.MorneOConnor.factory.SOSPasswordFactory;
import com.MorneOConnor.repository.SOSPasswordRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class SOSPasswordServiceTest {
    private SOSPasswordRepository repository;
    private SOSPassword password;

    private SOSPassword getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SOSPasswordRepository.getRepository();
        this.password = SOSPasswordFactory.createSOSPassword("Password1", 1);
    }

    @Test
    public void create() throws Exception {
        SOSPassword created = this.repository.create(this.password);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.password);
    }

    @Test
    public void update() throws Exception {
        String oldPassword = "Password12";
        SOSPassword updated = new SOSPassword.Builder().copy(getSaved()).oldSOSPassword(oldPassword).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(oldPassword, updated.getOldSOSPassword());
    }

    @Test
    public void read() throws Exception {
        SOSPassword saved = getSaved();
        SOSPassword read = this.repository.read(saved.getOldSOSPassword());
        Assert.assertNull(read);
    }

    @Test
    public void delete() throws Exception {
        SOSPassword saved = getSaved();
        this.repository.delete(saved.getOldSOSPassword());
        getAll();
    }

    @Test
    public void getAll() throws Exception {
        Set<SOSPassword> password = this.repository.getAll();
        System.out.println(password);
    }
}