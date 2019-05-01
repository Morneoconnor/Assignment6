package com.MorneOConnor.repository;

import com.MorneOConnor.domain.PasswordRequirements;
import com.MorneOConnor.factory.PasswordRequirementsFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class PasswordRequirementsRepositoryTest {
    private PasswordRequirementsRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = PasswordRequirementsRepository.getRepository();
    }

    @Test
    public void create() throws Exception {
        PasswordRequirements obj = PasswordRequirementsFactory.createPasswordRequirements
                ("", 20);

        this.repository.create(obj);
        Assert.assertEquals(20, obj.getPasswordCharactherLenght());
    }

    @Test
    public void read() throws Exception {
        Object obj = this.repository.read(20);
        Assert.assertNull(obj);
    }

    @Test
    public void update() throws Exception {
        PasswordRequirements obj = PasswordRequirementsFactory.createPasswordRequirements
                ("",20);

        Assert.assertEquals(20, obj.getPasswordCharactherLenght());
    }

    @Test
    public void delete() throws Exception {
        boolean item = false;

        this.repository.delete(20);
        Set<PasswordRequirements> obj = this.repository.getAll();
        if(obj.contains(20))
        {
            item = true;
        }
        else
            item = false;
        assertFalse(item);
    }

    @Test
    public void getAll() throws Exception {
        Set<PasswordRequirements> obj = this.repository.getAll();
        Assert.assertNotNull(obj);
    }

}