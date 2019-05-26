package com.MorneOConnor.service;

import com.MorneOConnor.domain.BlackBoardNewPassword;

import java.util.Set;

public interface IBlackBoardNewPasswordService extends IService<BlackBoardNewPassword, String> {
    Set<BlackBoardNewPassword> getAll();
}
