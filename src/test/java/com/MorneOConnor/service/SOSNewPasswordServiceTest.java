package com.MorneOConnor.service;

import com.MorneOConnor.domain.SOSNewPassword;
import com.MorneOConnor.factory.SOSNewPasswordFactory;
import com.MorneOConnor.repository.SOSNewPasswordRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class SOSNewPasswordServiceTest {
    private SOSNewPasswordRepository repository;
    private SOSNewPassword password;

    private SOSNewPassword getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SOSNewPasswordRepository.getRepository();
        this.password = SOSNewPasswordFactory.createSOSNewPassword("Password1",1);
    }

    @Test
    public void create() throws Exception {
        SOSNewPassword created = this.repository.create(this.password);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.password);
    }

    @Test
    public void update() throws Exception {
        String newPassword = "Password12";
        SOSNewPassword updated = new SOSNewPassword.Builder().copy(getSaved()).newSOSPassword(newPassword).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newPassword, updated.getNewSOSPassword());
    }

    @Test
    public void read() throws Exception {
        SOSNewPassword saved = getSaved();
        SOSNewPassword read = this.repository.read(saved.getNewSOSPassword());
        Assert.assertNull(read);
    }

    @Test
    public void delete() throws Exception {
        SOSNewPassword saved = getSaved();
        this.repository.delete(saved.getNewSOSPassword());
        getAll();
    }

    @Test
    public void getAll() throws Exception {
        Set<SOSNewPassword> password = this.repository.getAll();
        System.out.println(password);
    }
}