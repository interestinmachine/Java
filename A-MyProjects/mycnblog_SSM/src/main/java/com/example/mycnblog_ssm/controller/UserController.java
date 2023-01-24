package com.example.mycnblog_ssm.controller;

import com.example.mycnblog_ssm.common.AjaxResult;
import com.example.mycnblog_ssm.common.Constant;
import com.example.mycnblog_ssm.common.SecurityUtil;
import com.example.mycnblog_ssm.model.UserInfo;
import com.example.mycnblog_ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        int result = userService.addUser(username, SecurityUtil.encrypt(password));
        if (result == 1) {
            return AjaxResult.success(200,"注册成功",1);
        } else {
            return AjaxResult.fail(-1,"数据库添加数据出错",0);
        }
    }

    @RequestMapping("/login")
    public int login(HttpServletRequest request, String username, String password) {
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return 0;
        }

        UserInfo userInfo = userService.getUserByName(username);
        if (userInfo == null || userInfo.getId() < 0) {
            return -1; // 数据插入数据库失败
        } else {
            boolean result = SecurityUtil.decrypt(password, userInfo.getPassword());
            if (result) {
                HttpSession session = request.getSession();
                session.setAttribute(Constant.SESSION_USERINFO_KEY, userInfo);
                return 1;
            }
        }
        return -1;
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public boolean logout(HttpServletRequest request) {
        // 获取到当前用户的 session
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            // 如果 session 不为空，并且 session 里的属性不为空，则代表存在该用户
            // 移除当前的 session
            session.removeAttribute(Constant.SESSION_USERINFO_KEY);
        }
        // 如果 session 不存在 或者 该 session 中无 userinfo 的key，则不进行退出
        return true;
    }

    @RequestMapping("/myinfo")
    public UserInfo myInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null &&
                session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            return (UserInfo) session.getAttribute(Constant.SESSION_USERINFO_KEY);
        }
        return null;
    }

    @RequestMapping("/myinfobyuid")
    public UserInfo myInfoByUid(Integer uid) {
        return userService.myInfoByUid(uid);
    }
}
