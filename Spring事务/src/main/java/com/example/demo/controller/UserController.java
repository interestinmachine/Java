package com.example.demo.controller;

import com.example.demo.model.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 数据源事务管理器
    @Resource
    private DataSourceTransactionManager transactionManager;

    // 事务的定义
    @Resource
    private TransactionDefinition transactionDefinition;

    @RequestMapping("/adduser")
    public int addUser(UserInfo userInfo) {
        // 用户名和密码不能为空
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername())
            || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }

        // 开启事务
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        int ret = userService.addUser(userInfo);
        System.out.println("addUser 受影响的行数：" + ret);

        // 提交事务/回滚事务
        // 回滚
        // transactionManager.rollback(transactionStatus);

        // 事务提交
        transactionManager.commit(transactionStatus);
        return ret;
    }

    @RequestMapping("/adduser2")
    @Transactional(timeout = 1)
    public int addUser2(UserInfo userInfo) {
        // 用户名和密码不能为空
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername())
                || !StringUtils.hasLength(userInfo.getPassword())) {
            return 0;
        }
        int ret = userService.addUser(userInfo);
        System.out.println("addUser 受影响的行数：" + ret);
        return ret;
    }
}
