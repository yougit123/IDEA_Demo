package com.at.dao;

import com.at.pojo.Account;
import com.at.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;


/**
 * Author:  by AT
 * Description: com.at.test
 * version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMybatis {
    @Autowired
    AccountService accountService;

    @Test
    public void run1() {
        List<Account> all = accountService.findAll();
        Iterator<Account> iterator = all.iterator();
        while (iterator.hasNext()) {
            Account next = iterator.next();
            System.out.println(next);
        }

    }

    public void run2() throws Exception {
        InputStream sqlMapConfig = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(sqlMapConfig);
        SqlSession sqlSession = build.openSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Account account = new Account();
        account.setMoney((double) 60);
        account.setName("小龙女");
        mapper.saveAccount(account);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        if (sqlMapConfig != null)
            sqlMapConfig.close();
    }
}
