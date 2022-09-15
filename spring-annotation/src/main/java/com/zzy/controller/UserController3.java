package com.zzy.controller;

import com.zzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController3 {

    private UserService userService;

    //3.注入方法3：setter注入
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

