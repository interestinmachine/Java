package com.zzy;

import com.zzy.component.UserBean;
import com.zzy.controller.UserController;
import com.zzy.controller.UserController4;
import com.zzy.controller.UserController5;
import com.zzy.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作为 启动类（不是必须的，只是方便演示spring功能）
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        UserController4 userController4 = context.getBean(UserController4.class);
        User u4 = userController4.getUser();
        System.out.println("UserController4--User: " + u4);

        UserController5 userController5 = context.getBean("userController5",UserController5.class);
        User u5 = userController5.getUser();
        System.out.println("UserController4--User: " + u5);


//        // 这里写入的id为：类名首字母小写的形式
//        UserController controller = context.getBean("userController",UserController.class);
//        controller.sayHi("zzy");
//
//        ApplicationContext context1 = new ClassPathXmlApplicationContext("spring.xml");
//        User user = context1.getBean("u1",User.class);
//        User user2 = context1.getBean("u2",User.class);
//        System.out.println(user.toString());
//        System.out.println(user2.toString());
    }
}

