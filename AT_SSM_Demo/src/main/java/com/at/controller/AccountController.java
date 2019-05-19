package com.at.controller;

import com.at.pojo.Account;
import com.at.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author:  by AT
 * Description: com.at.controller
 * version: 1.0
 */
@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("findAll")
    public String findAll(Model model) {
        List<Account> accountList = accountService.findAll();
        model.addAttribute("accountList",accountList);
        return "list";
    }
    @RequestMapping("saveAccount")
    public String saveAccount(Account account, HttpServletResponse response, HttpServletRequest request) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return "list";
    }
}
