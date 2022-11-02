package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(void com.example.dao.BookDao.update())")
    private void ps(){}

    @Pointcut("execution(int com.example.dao.BookDao.select())")
    private void pt(){}

//    @Before("ps()")
//    public void before() {
//        System.out.println("before advice...");
//    }

    @After("pt()")
    public void after() {
        System.out.println("after advice...");
    }

//    @Around("pt()")
//    public void around(ProceedingJoinPoint pjp) throws  Throwable{
//        System.out.println("around before advice...");
//        pjp.proceed();
//        System.out.println("around after advice...");
////        return ret;
//    }

    @AfterReturning("pt()")
    public void afterReturning() {
        System.out.println("afterReturning advice...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing() {
        System.out.println("afterThrowing advice...");
    }
}
