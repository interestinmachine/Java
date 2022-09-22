package com.example.springTransaction.Service;

import com.example.springTransaction.mapper.UserMapper;
import com.example.springTransaction.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int add(UserInfo userInfo) {
        return userMapper.add(userInfo);
    }
}
