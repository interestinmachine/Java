package com.example.mycnblog_ssm.service;

import com.example.mycnblog_ssm.mapper.UserMapper;
import com.example.mycnblog_ssm.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务层
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int addUser(String username,String password) {
        return userMapper.addUser(username,password);
    }

    public UserInfo login(String username,String password) {
        return userMapper.login(username,password);
    }

    public UserInfo myInfoByUid(Integer uid) {
        return userMapper.myInfoByUid(uid);
    }

    public UserInfo getUserByName(String username) {
        return userMapper.getUserByName(username);
    }
}
