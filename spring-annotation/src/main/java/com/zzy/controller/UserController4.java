package com.zzy.controller;

import com.zzy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController4 {
    @Autowired
    private User u1;

    public User getUser() {
        User user = u1;
        u1.setAge(30);
        u1.setName("赵四");
        return user;
    }
}

