package com.MorneOConnor.repository;

import com.MorneOConnor.domain.BlackBoardPassword;

import java.util.Set;

public interface IBlackBoardPasswordRepository extends IRepository<BlackBoardPassword, String> {
    Set<BlackBoardPassword> getAll();
}