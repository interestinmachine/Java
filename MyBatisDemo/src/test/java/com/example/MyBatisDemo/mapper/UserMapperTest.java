package com.example.MyBatisDemo.mapper;

import com.example.MyBatisDemo.model.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void getUserById() {
        UserInfo userInfo = userMapper.getUserById(1);
        Assertions.assertNotNull(userInfo);
    }

    @Test
    // 事务，操作可以不污染数据库
    @Transactional
    void update() {
        int result = userMapper.update(2,"jjjjj");
        Assertions.assertEquals(1,result);
    }

    @Test
    @Transactional
    void del() {
        int result = userMapper.del(2);
        Assertions.assertEquals(1,result);
    }

    @Test
    @Transactional
    void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("赵华");
        userInfo.setPassword("1234");
        userInfo.setPhoto("default.png");
        int result = userMapper.add(userInfo);
        Assertions.assertEquals(1,result);
    }

    @Test
    @Transactional
    void addGetId() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("赵华");
        userInfo.setPassword("1234");
        userInfo.setPhoto("default.png");
        System.out.println("添加之前 user id：" + userInfo.getId());
        int result = userMapper.addGetId(userInfo);
        System.out.println("添加之后 user id：" + userInfo.getId());
        Assertions.assertEquals(1,result);
    }
}