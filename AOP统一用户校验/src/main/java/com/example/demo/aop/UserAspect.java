package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserAspect implements HandlerInterceptor {
    // 定义切点⽅法 controller 包下、⼦孙包下所有类的所有⽅法
    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    public void pointcut(){ }
    // 前置⽅法
    @Before("pointcut()")
    public void doBefore(){
    }
    // 环绕⽅法
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        Object obj = null;
        System.out.println("Around ⽅法开始执⾏");
        try {
            // 执⾏拦截⽅法
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Around ⽅法结束执⾏");
        return obj;
    }
}

