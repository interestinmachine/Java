package com.zzy.service;

import com.zzy.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUser() {
        User user = new User();
        user.setName("aaa");
        user.setAge(18);
        return user;
    }
}

