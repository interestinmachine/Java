package com.example.dynamic_proxy.service;

// 表示功能的，厂家和商家都要完成的功能
public interface UsbSell {

    // 定义方法 参数 amount 表示一次购买的数量，暂时不用
    // 返回值白哦是一个U盘的价格
    float sell(int amount);
}
