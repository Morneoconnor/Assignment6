package com.MorneOConnor.repository;

import com.MorneOConnor.domain.BlackBoardNewPassword;

import java.util.Set;

public interface IBlackBoardNewPasswordRepository extends IRepository<BlackBoardNewPassword, String> {
    Set<BlackBoardNewPassword> getAll();
}