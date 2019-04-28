package com.MorneOConnor.repository;

import com.MorneOConnor.domain.PasswordRequirements;

import java.util.Set;

public interface IPasswordRequirementsRepository extends IRepository<PasswordRequirements, String> {
    Set<PasswordRequirements> getAll();
}
