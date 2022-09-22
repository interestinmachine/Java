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
    public boolean login(HttpServletRequest request, String username, String password) {
        boolean result = false;
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("userinfo","userinfo");
            return true;
        }
        return result;
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request, String username, String password) {
        return "hello index!!";
    }

    @RequestMapping("/execption")
    public int num() {
        int num = 10/0;
        return num;
    }
}
