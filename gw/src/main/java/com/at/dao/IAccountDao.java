package com.at.dao;

import com.at.pojo.Account;

/**
 * 账户的持久层接口
 */
public interface IAccountDao {
    /**
     * 根据 id 查询账户信息
     */
    Account findAccountById(Integer id);

    /**
     * 根据名称查询账户信息
     *
     */
    Account findAccountByName(String name);

    /**
     * 更新账户信息
     */
    void updateAccount(Account account);
}