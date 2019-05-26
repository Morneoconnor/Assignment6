package com.MorneOConnor.service;

import com.MorneOConnor.domain.PasswordRequirements;

import java.util.Set;

public interface IPasswordRequirementsService extends IService<PasswordRequirements, String> {
    Set<PasswordRequirements> getAll();
}