package com.MorneOConnor.repository;

import com.MorneOConnor.domain.SOSNewPassword;

import java.util.Set;

public interface ISOSNewPasswordRepository extends IRepository<SOSNewPassword, String> {
    Set<SOSNewPassword> getAll();
}