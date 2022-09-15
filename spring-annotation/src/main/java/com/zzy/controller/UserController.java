package com.zzy.controller;

import com.zzy.model.User;
import com.zzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

    //1.注入方法1：属性注入
    @Autowired
    private UserService userService;

    public User getUser() {
        return userService.getUser();
    }
}

