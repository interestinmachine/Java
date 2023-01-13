package com.example.dynamic_proxy.factory;

import com.example.dynamic_proxy.service.UsbSell;

// 目标类：金士顿厂家，不接受用户的单独购买
public class UsbKingFactory implements UsbSell {
    @Override
    public float sell(int amount) {
        System.out.println("目标类中，执行sell目标方法");
        // 一个U盘85元
        // 后期根据amount，可以实现不同的价格，如买10000个，单价为80
        return 85.0f;
    }
}
