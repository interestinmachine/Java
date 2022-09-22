package com.example.springaopdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class UserAspect {

    // 定义一个切点，设置拦截规则
    @Pointcut("execution(* com.example.springaopdemo.controller.UserController.*(..))")
    public void pointcut() {

    }

    /**
     * 定义 pointcut 切点的前置通知
     * 在执行目标方法之前执行的方法叫前置通知
     */
    @Before("pointcut()")
    public void doBefore() {
        System.out.println("前置通知：被执行了");
    }

    @Around("pointcut()")
    public Object doArount(ProceedingJoinPoint joinPoint) {
        Object result = null;
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            result = joinPoint.proceed();
            stopWatch.stop();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println(joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName() + " 方法执行时间： " + stopWatch.getTotalTimeMillis() + "ms");
        return result;
    }
}
