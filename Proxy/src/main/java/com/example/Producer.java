package com.example;

public class Producer implements IProducer{
    @Override
    public void Product(float amount) {
        System.out.println("代理后生产所需费用为：" + amount*80);
    }
}

