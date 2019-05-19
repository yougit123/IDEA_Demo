package com.at.service;

import com.at.pojo.Account;

import java.util.List;

/**
 * Author:  by AT
 * Description: com.at.service
 * version: 1.0
 */
public interface AccountService {
    List<Account> findAll();

    void saveAccount(Account account);
}
