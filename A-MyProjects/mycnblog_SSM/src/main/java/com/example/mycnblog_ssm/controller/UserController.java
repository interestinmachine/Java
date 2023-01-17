package com.example.mycnblog_ssm.controller;

import com.example.mycnblog_ssm.common.AjaxResult;
import com.example.mycnblog_ssm.model.UserInfo;
import com.example.mycnblog_ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制侵权
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
    public Object reg(String username,String password) {
        // 1. 非空校验
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return AjaxResult.fail(-1,"请求参数出错！",0);
        }

        // 2. 进行添加操作
        int result = userService.addUser(username,password);
        if (result == 1) {
            return AjaxResult.success(200,"注册成功",1);
        } else {
            return AjaxResult.fail(-1,"数据库添加数据出错",0);
        }
    }

    @RequestMapping("/login")
    public int login(String username,String password) {
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return 0;
        }

        UserInfo userInfo = userService.login(username,password);
        if (userInfo == null || userInfo.getId() < 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @RequestMapping("/hi")
    public String sayHi() {
        return "Hi,body!!";
    }
}
