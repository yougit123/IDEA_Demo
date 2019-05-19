package com.at.dao;

import com.at.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author:  by AT
 * Description: com.at.dao
 * version: 1.0
 */
@Repository
public interface AccountDao {
    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account (name,money) value(#{name},#{money})")
    void saveAccount(Account account);
}
