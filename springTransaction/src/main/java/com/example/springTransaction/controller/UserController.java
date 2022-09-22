package com.example.springTransaction.controller;

import com.example.springTransaction.Service.UserService;
import com.example.springTransaction.model.UserInfo;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private DataSourceTransactionManager transactionManager;

    @Resource
    private TransactionDefinition transactionDefinition;

    // 此方法中使用编程式的事务
    @RequestMapping("/add")
    public int add(UserInfo userInfo) {
        // 非空校验（验证用户名和密码不为空）
        if (userInfo == null || !StringUtils.hasLength(userInfo.getUsername())
        || !StringUtils.hasLength(userInfo.getPassword())) return 0;

        // 开启事务（获取事务）
        TransactionStatus transactionStatus =
                transactionManager.getTransaction(transactionDefinition);
        int result = userService.add(userInfo);
        System.out.println("add 受影响的行数：" + result);

        // 提交事务或回滚事务
        // transactionManager.rollback(transactionStatus); // 回滚事务
        transactionManager.commit(transactionStatus); // 提交事务
        return result;
    }
}
