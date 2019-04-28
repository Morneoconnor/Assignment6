package com.MorneOConnor.repository;

import com.MorneOConnor.domain.SOSPassword;

import java.util.Set;

public interface ISOSPasswordRepository extends IRepository<SOSPassword, String> {
    Set<SOSPassword> getAll();
}
