package com.example.dynamic_proxy.handler;

import com.example.dynamic_proxy.service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 必须实现 InvocationHandler 的接口，完成代理类要完成的功能（1）调用目标方法 （2）功能增强
public class MySellHandler implements InvocationHandler {

    private Object target = null;

    // 动态代理：目标对象是活动的，不是固定的，需要传入进来。
    // 传入是谁，就给谁创建代理
    public MySellHandler(Object target) {
        // 给目标对象赋值
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object res = null;
        res = method.invoke(target,args);//执行目标方法

        // 方法增强：增加价格
        if (res != null) {
            Float price = (Float) res;
            price += 25;
            res = price;
        }

        // 在目标类的方法调用后，可以做其他的功能，都是增强的意思
        System.out.println("淘宝商家，给你返一个优惠卷");

        // 增加的价格
        return res;
    }
}
