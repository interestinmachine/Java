package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CalcController {

    @RequestMapping("/calc")
    public String getAdd(Integer num1,Integer num2) {
        if (num1 == null || num2 == null) {
            log.error("参数缺乏");
            return "参数不正确！<a href='javascript:history.go(-1);'>返回</a>";
        }

        return "<h1>结果 = " + (num1+num2) + "</h1><a href='javascript:history.go(-1);'>返回</a>";
    }
}
