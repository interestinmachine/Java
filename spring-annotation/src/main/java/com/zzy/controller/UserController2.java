package com.zzy.controller;

import com.zzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController2 {

    private UserService userService;

    //2. 注入方法2：构造方法注入
    @Autowired
    public UserController2(UserService userService) {
        this.userService = userService;
    }
}

