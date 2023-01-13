package com.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class cglibClient {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param o
             * @param method
             * @param objects
             * 以上三个参数和基于 JDK 代理中的 invoke 方法的参数是一样的
             * @param methodProxy：当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;

                //1. 获取方法执行的参数
                Float amount = (Float) objects[0];
                // 2. 判断当前方法是不是生产产品
                if ("Product".equals(method.getName())) {
                    returnValue = method.invoke(producer,amount*0.8f);
                }

                return returnValue;
            }
        });

        cglibProducer.Product(5);
    }
}
