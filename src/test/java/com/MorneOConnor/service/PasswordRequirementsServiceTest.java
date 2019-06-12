package com.MorneOConnor.service;

import com.MorneOConnor.domain.PasswordRequirements;
import com.MorneOConnor.factory.PasswordRequirementsFactory;
import com.MorneOConnor.repository.PasswordRequirementsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class PasswordRequirementsServiceTest {
    private PasswordRequirementsRepository repository;
    private PasswordRequirements requirements;

    private PasswordRequirements getSaved() {
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = PasswordRequirementsRepository.getRepository();
        this.requirements = PasswordRequirementsFactory.createPasswordRequirements("Password",7, 1);
    }

    @Test
    public void create() throws Exception {
        PasswordRequirements created = this.repository.create(this.requirements);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.requirements);
    }

    @Test
    public void update() throws Exception {
        int newLength = 11;
        PasswordRequirements updated = new PasswordRequirements.Builder().copy(getSaved()).passwordCharactherLenght(newLength).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newLength, updated.getPasswordCharactherLenght());
    }

    @Test
    public void read() throws Exception {
        PasswordRequirements saved = getSaved();
        PasswordRequirements read = this.repository.read(saved.getPasswordCharactherLenght());
        Assert.assertNull(read);
    }

    @Test
    public void delete() throws Exception {
        PasswordRequirements saved = getSaved();
        this.repository.delete(saved.getPasswordCharactherLenght());
        getAll();
    }

    @Test
    public void getAll() throws Exception {
        Set<PasswordRequirements> password = this.repository.getAll();
        System.out.println(password);
    }
}