package com.hw.service.impl;


import com.hw.mapper.AccountMapper;
import com.hw.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean edit() {
        accountMapper.updateMinus();
//        System.out.println(1 / 0);
        accountMapper.updatePlus();
        return true;
    }
}
