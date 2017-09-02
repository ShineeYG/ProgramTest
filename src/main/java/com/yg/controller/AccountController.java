package com.yg.controller;

import com.yg.bean.Account;
import com.yg.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by yg on 17/9/1.
 */


@Controller
public class AccountController {

    @Resource
    public AccountService accountService;

    @RequestMapping("account_list")
    public String jumpAccount (){
        return "/account/account_list";
    }


}
