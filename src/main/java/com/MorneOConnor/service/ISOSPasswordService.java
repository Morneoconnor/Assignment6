package com.MorneOConnor.service;

import com.MorneOConnor.domain.SOSPassword;

import java.util.Set;

public interface ISOSPasswordService extends IService<SOSPassword, String> {
    Set<SOSPassword> getAll();
}
