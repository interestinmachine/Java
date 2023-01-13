package com.example.ui;

import com.example.config.SpringConfig;
import com.example.dao.IAccountDao;
import com.example.service.IAccountService;
import com.example.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class client {

    /**
     * 获取 spring 的 IoC核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        // 1, 获取核心容器对象
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 2. 根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");

        as.saveAccount();

    }
}
