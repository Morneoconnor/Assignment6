package com.MorneOConnor.repository;

import com.MorneOConnor.domain.BlackBoardNewPassword;
import com.MorneOConnor.factory.BlackBoardNewPasswordFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class BlackBoardNewPasswordRepositoryTest {
    private BlackBoardNewPasswordRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = BlackBoardNewPasswordRepository.getRepository();
    }

    @Test
    public void create() throws Exception {
        BlackBoardNewPassword obj = BlackBoardNewPasswordFactory.createBlackBoardNewPassword
                ("Password123!");

        this.repository.create(obj);
        Assert.assertEquals("Password123", obj.getNewBlackBoardPassword());
    }

    @Test
    public void read() throws Exception {
        Object obj = this.repository.read("Testing");
        Assert.assertNull(obj);
    }

    @Test
    public void update() throws Exception {
        BlackBoardNewPassword obj = BlackBoardNewPasswordFactory.createBlackBoardNewPassword
                ("Password123!");
        Assert.assertEquals("Password123!", obj.getNewBlackBoardPassword());
    }

    @Test
    public void delete() throws Exception {
        boolean item = false;
        this.repository.delete("Password123!");
        Set<BlackBoardNewPassword> obj = this.repository.getAll();
        if(obj.contains("Password123!"))
        {
            item = true;
        }
        else
            item = false;
        assertFalse(item);
    }

    @Test
    public void getAll() throws Exception {
        Set<BlackBoardNewPassword> obj = this.repository.getAll();
        Assert.assertNotNull(obj);
    }

}