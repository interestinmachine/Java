package com.example.mycnblog_ssm.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public HashMap<String, Object> exAdvice(ArithmeticException e) {
        return AjaxResult.fail(-1,e.getMessage(),0);
    }
}
