package com.example.springaopdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("/sayhi")
    @ResponseBody
    public String sayhi() {
        System.out.println("执行 sayhi");
        return "hello,world!";
    }

    @RequestMapping("/sayhi2")
    @ResponseBody
    public String sayhi2() {
        System.out.println("执行 sayhi2");
        return "hello,world!";
    }

}
