package com.zzy.component;

import com.zzy.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class UserBean {
    @Bean(name = {"u1"})
    @Scope("prototype")
    public User user1() {
        User user = new User();
        user.setAge(18);
        user.setName("aaa");
        return user;
    }

    @Bean(name = {"u2"})
    public User user2() {
        User user = new User();
        user.setAge(30);
        user.setName("yyy");
        return user;
    }
}

