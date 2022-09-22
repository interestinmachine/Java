package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@ControllerAdvice
public class MyExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HashMap<String,Object> exceptionHandler(Exception e) {
        HashMap<String,Object> mp = new HashMap<>();
        mp.put("success",0);
        mp.put("status",1);
        mp.put("msg",e.getMessage());
        return mp;
    }
}
