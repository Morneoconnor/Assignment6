package com.MorneOConnor.service;

import com.MorneOConnor.domain.SOSNewPassword;

import java.util.Set;

public interface ISOSNewPasswordService extends IService<SOSNewPassword, String> {
    Set<SOSNewPassword> getAll();
}