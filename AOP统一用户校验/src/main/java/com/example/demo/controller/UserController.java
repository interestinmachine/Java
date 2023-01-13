package com.example.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public boolean login(HttpServletRequest request,String username,String password) {
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
            if ("admin".equals(username) && "admin".equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("userinfo","admin");
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @RequestMapping("/index1")
    public String index1(HttpServletRequest request,String username,String password) {
        int i = 10/0;
        return "hello index";
    }

    @RequestMapping("/index2")
    public String index2(HttpServletRequest request,String username,String password) {
        Object p = null;
        p.equals("a");
        return "hello index";
    }
}
