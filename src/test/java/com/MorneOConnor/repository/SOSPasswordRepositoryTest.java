package com.MorneOConnor.repository;

import com.MorneOConnor.domain.SOSPassword;
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
        this.repository.create(null);
        Assert.assertEquals(null, null);
    }

    @Test
    public void read() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        Set<SOSPassword> students = this.repository.getAll();
        Assert.assertEquals(1, students.size());
    }

}