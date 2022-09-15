package com.example.demo.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j // 获取log对象
@ResponseBody
public class UserServer {

    @RequestMapping("/sayhi2")
    public void sayHi2() {
        log.info("info 信息");
        log.warn("warn 信息");
        log.error("error 信息");
        log.trace("trace 信息");
        log.debug("debug 信息");
    }
}
