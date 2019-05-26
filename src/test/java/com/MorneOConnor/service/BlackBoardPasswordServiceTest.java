package com.MorneOConnor.service;

import com.MorneOConnor.domain.BlackBoardPassword;
import com.MorneOConnor.factory.BlackBoardPasswordFactory;
import com.MorneOConnor.repository.BlackBoardPasswordRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class BlackBoardPasswordServiceTest {
    private BlackBoardPasswordRepository repository;
    private BlackBoardPassword password;

    private BlackBoardPassword getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BlackBoardPasswordRepository.getRepository();
        this.password = BlackBoardPasswordFactory.createBlackBoardPassword("Password");
    }

    @Test
    public void create() throws Exception {
        BlackBoardPassword created = this.repository.create(this.password);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.password);
    }

    @Test
    public void update() throws Exception {
        String oldPassword = "Password1";
        BlackBoardPassword updated = new BlackBoardPassword.Builder().copy(getSaved()).oldBlackBoardPassword(oldPassword).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(oldPassword, updated.getOldBlackBoardPassword());
    }

    @Test
    public void delete() throws Exception {
        BlackBoardPassword saved = getSaved();
        this.repository.delete(saved.getOldBlackBoardPassword());
        getAll();
    }

    @Test
    public void read() throws Exception {
        BlackBoardPassword saved = getSaved();
        BlackBoardPassword read = this.repository.read(saved.getOldBlackBoardPassword());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void getAll() throws Exception {
        Set<BlackBoardPassword> password = this.repository.getAll();
        System.out.println("In getall, all = " + password);
    }
}