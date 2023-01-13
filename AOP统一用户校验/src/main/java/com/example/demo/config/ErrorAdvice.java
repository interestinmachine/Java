package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * 统一异常处理
 */
@ControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HashMap<String, Object> exAdvice(Exception e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("code","-1");
        result.put("msg",e.getMessage());
        return result;
    }
}
