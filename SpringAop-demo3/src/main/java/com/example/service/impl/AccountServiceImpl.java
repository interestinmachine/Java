package com.example.service.impl;

import com.example.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("saveAccount...");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("updateAccount...");
    }

    @Override
    public void deleteAccount() {
        System.out.println("deleteAccount...");
    }
}
