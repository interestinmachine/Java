package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/sayhi")
    public void sayHi() {
        logger.info("info 信息");
        logger.warn("warn 信息");
        logger.error("error 信息");
        logger.trace("trace 信息");
        logger.debug("debug 信息");
    }
}
