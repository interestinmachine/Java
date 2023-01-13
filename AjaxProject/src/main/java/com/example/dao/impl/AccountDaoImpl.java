package com.example.dao.impl;

import com.example.dao.IAccountDao;
import com.example.service.IAccountService;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("save Account111...");
    }
}
