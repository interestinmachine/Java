package com.example.config;

import com.example.service.impl.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
@ComponentScan("com.example")
public class SpringConfig {

    @Bean(name="accountService")
    public AccountServiceImpl accountServiceImpl() {

        return new AccountServiceImpl();
    }

}
