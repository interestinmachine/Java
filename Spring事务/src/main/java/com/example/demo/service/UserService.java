package com.example.demo.service;

import com.example.demo.mapper.LogMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.LogInfo;
import com.example.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogService logService;

    @Transactional(propagation = Propagation.NESTED)
    public int addUser(UserInfo userInfo) {
        int ret = userMapper.addUser(userInfo);
        System.out.println("执行add方法");
        // 插入日志
        logService.addLog("用户插入：" + userInfo.getUsername());
        return ret;
    }
}



















