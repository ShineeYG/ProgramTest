package com.yg.service.impl;

import com.yg.mapper.AccountMapper;
import com.yg.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yg on 17/9/1.
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    public AccountMapper accountMapper;

}
