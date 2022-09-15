package com.zzy.controller;

import com.zzy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController5 {
    @Autowired
    private User u1;

    public User getUser() {
        return u1;
    }
}

