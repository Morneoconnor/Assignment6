package com.MorneOConnor.service;

import com.MorneOConnor.domain.BlackBoardPassword;

import java.util.Set;

public interface IBlackBoardPasswordService extends IService<BlackBoardPassword, String> {
    Set<BlackBoardPassword> getAll();
}
