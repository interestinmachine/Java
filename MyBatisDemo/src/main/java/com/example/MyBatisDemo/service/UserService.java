package com.example.MyBatisDemo.service;

import com.example.MyBatisDemo.mapper.UserMapper;
import com.example.MyBatisDemo.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public UserInfo getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
}
