package com.example.MyBatisDemo.mapper;

import com.example.MyBatisDemo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void getUserById() {
        UserInfo userInfo = userMapper.getUserById(null);
        System.out.println("用户信息为："+userInfo);
        //Assertions.assertNotNull(userInfo);
    }

//    @Test
//    // 事务，操作可以不污染数据库
//    @Transactional
//    void update() {
//        int result = userMapper.update(2,"jjjjj");
//        Assertions.assertEquals(1,result);
//    }
//
//    @Test
//    @Transactional
//    void del() {
//        int result = userMapper.del(2);
//        Assertions.assertEquals(1,result);
//    }
//
//    @Test
//    @Transactional
//    void add() {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("赵华");
//        userInfo.setPassword("1234");
//        userInfo.setPhoto("default.png");
//        int result = userMapper.add(userInfo);
//        Assertions.assertEquals(1,result);
//    }
//
//    @Test
//    @Transactional
//    void addGetId() {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("赵华");
//        userInfo.setPassword("1234");
//        userInfo.setPhoto("default.png");
//        System.out.println("添加之前 user id：" + userInfo.getId());
//        int result = userMapper.addGetId(userInfo);
//        System.out.println("添加之后 user id：" + userInfo.getId());
//        Assertions.assertEquals(1,result);
//    }

    @Test
    void getUserByName() {
        UserInfo userInfo = userMapper.getUserByName("admin");
        Assertions.assertNotNull(userInfo);
    }

    @Test
    void login() {
        List<UserInfo> userInfo = userMapper.login("admin","' or 1='1");
        System.out.println("用户信息："+userInfo);
    }

    @Test
    void getUserByName2() {
        List<UserInfo> userInfo = userMapper.getUserByName2("a");
        Assertions.assertNotNull(userInfo);
    }

    @Test
    void add2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setPassword("123");
        //userInfo.setPhoto("123.png");
        int result = userMapper.add2(userInfo);
        log.info("用户信息："+userInfo);
    }

    @Test
    void getUserAndArticleById() {
        UserInfo userInfo = userMapper.getUserAndArticleById(1);
        log.info("用户信息：" + userInfo);
    }

    @Test
    void add3() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("王五");
        userInfo.setPassword("123");
        userInfo.setPhoto("123.png");
        int result = userMapper.add3(userInfo);
        log.info("用户信息："+userInfo);
    }

    @Test
    void updateById() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(5);
        userInfo.setName("拉普拉斯");
        int result = userMapper.updateById(userInfo);
    }

    @Test
    void delIds() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        int result = userMapper.delIds(list);
    }
}