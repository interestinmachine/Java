package com.example.dao.impl;

import com.example.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("save Account222222222...");
    }
}
