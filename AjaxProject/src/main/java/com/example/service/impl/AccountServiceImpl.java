package com.example.service.impl;

import com.example.dao.IAccountDao;
import com.example.dao.impl.AccountDaoImpl;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao1 = null;

    @PostConstruct
    public void init() {
        System.out.println("初始化方法执行了");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法执行了");
    }

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    @Override
    public void saveAccount() {
        accountDao1.saveAccount();
    }
}
