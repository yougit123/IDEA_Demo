package com.at.dao.impl;

import com.at.RowMapper.AccountRowMapper;
import com.at.dao.IAccountDao;
import com.at.pojo.Account;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 账户的持久层实现类
 * 此版本 dao，只需要给它的父类注入一个数据源
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
    public Account findAccountById(Integer id) {
        List<Account> list = getJdbcTemplate().query("select * from account where id = ? ", new AccountRowMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> list = getJdbcTemplate().query("select * from account where name = ? ", new AccountRowMapper(), name);
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() > 1) {
            throw new RuntimeException("结果集不唯一，不是只有一个账户对象");
        }
        return list.get(0);
    }

    public void updateAccount(Account account) {
        int update = getJdbcTemplate().update("update account set money = ? where id = ? ", account.getMoney(), account.getId());
    }
}