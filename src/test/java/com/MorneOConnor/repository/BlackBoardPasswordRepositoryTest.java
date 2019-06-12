package com.MorneOConnor.repository;

import com.MorneOConnor.domain.BlackBoardPassword;
import com.MorneOConnor.factory.BlackBoardPasswordFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class BlackBoardPasswordRepositoryTest {
    private BlackBoardPasswordRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = BlackBoardPasswordRepository.getRepository();
    }

    @Test
    public void create() throws Exception {
        BlackBoardPassword obj = BlackBoardPasswordFactory.createBlackBoardPassword
                ("Password111!", 1);

        this.repository.create(obj);
        Assert.assertEquals("Password111!", obj.getOldBlackBoardPassword());
    }

    @Test
    public void read() throws Exception {
        Object obj = this.repository.read("Password111!");
        Assert.assertNull(obj);
    }

    @Test
    public void update() throws Exception {
        BlackBoardPassword obj = BlackBoardPasswordFactory.createBlackBoardPassword
                ("Password111!", 1);
        Assert.assertEquals("Password111!", obj.getOldBlackBoardPassword());
    }

    @Test
    public void delete() throws Exception {
        boolean item = false;
        this.repository.delete("Password111!");
        Set<BlackBoardPassword> obj = this.repository.getAll();
        if(obj.contains("Password111!"))
        {
            item = true;
        }
        else
            item = false;
        assertFalse(item);
    }



    @Test
    public void getAll() throws Exception {
        Set<BlackBoardPassword> obj = this.repository.getAll();
        Assert.assertNotNull(obj);
    }

}