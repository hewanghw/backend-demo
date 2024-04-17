package com.hw.controller;

import com.hw.domain.Account;
import com.hw.mapper.AccountMapper;
import com.hw.service.AccountService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/account")
@RestController
public class AccountController {
    private final AccountService accountService;

    private final AccountMapper accountMapper;

    public AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/getAll")
    List<Account> getAll(){
        return accountMapper.selectAll();
    }

    @GetMapping("/edit")
    boolean edit(){
        accountService.edit();
        return true;
    }


}
