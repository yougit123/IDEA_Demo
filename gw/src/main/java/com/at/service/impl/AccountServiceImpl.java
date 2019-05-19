package com.at.service.impl;

import com.at.dao.IAccountDao;
import com.at.pojo.Account;
import com.at.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void transfer(String sourceName, String targeName, Float money) {
        int dint = 0;
        //1.根据名称查询两个账户
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targeName);
        //2.修改两个账户的金额
        source.setMoney(source.getMoney() - money);//转出账户减钱
        target.setMoney(target.getMoney() + money);//转入账户加钱
        //3.更新两个账户
        accountDao.updateAccount(source);
        dint= 1/0;
        accountDao.updateAccount(target);
    }
}