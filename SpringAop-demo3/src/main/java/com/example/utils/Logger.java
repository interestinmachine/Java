package com.example.utils;

// 用于记录日志的工具类，提供了公共的代码
public class Logger {

    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog() {
        System.out.println("Logger 类中的 printLog 方法开始打印日志");
    }
}
