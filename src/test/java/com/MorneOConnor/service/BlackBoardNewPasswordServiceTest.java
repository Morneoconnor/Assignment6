package com.MorneOConnor.service;

import com.MorneOConnor.domain.BlackBoardNewPassword;
import com.MorneOConnor.factory.BlackBoardNewPasswordFactory;
import com.MorneOConnor.repository.BlackBoardNewPasswordRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class BlackBoardNewPasswordServiceTest {
    private BlackBoardNewPasswordRepository repository;
    private BlackBoardNewPassword password;

    private BlackBoardNewPassword getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = BlackBoardNewPasswordRepository.getRepository();
        this.password = BlackBoardNewPasswordFactory.createBlackBoardNewPassword("Password");
    }

    @Test
    public void create() throws Exception {
        BlackBoardNewPassword created = this.repository.create(this.password);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.password);
    }

    @Test
    public void update() throws Exception {
        String newPassword = "Password1";
        BlackBoardNewPassword updated = new BlackBoardNewPassword.Builder().copy(getSaved()).newBlackBoardPassword(newPassword).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newPassword, updated.getNewBlackBoardPassword());
    }

    @Test
    public void delete() throws Exception {
        BlackBoardNewPassword saved = getSaved();
        this.repository.delete(saved.getNewBlackBoardPassword());
        getAll();
    }

    @Test
    public void read() throws Exception {
        BlackBoardNewPassword saved = getSaved();
        BlackBoardNewPassword read = this.repository.read(saved.getNewBlackBoardPassword());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void getAll() throws Exception {
        Set<BlackBoardNewPassword> password = this.repository.getAll();
        System.out.println("In getall, all = " + password);
    }

}