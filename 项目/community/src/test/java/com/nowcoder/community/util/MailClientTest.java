package com.nowcoder.community.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

@SpringBootTest
class MailClientTest {

    @Resource
    private MailClient mailClient;

    // 使用模板引擎发送邮件的核心类
    @Autowired(required = false)
    private TemplateEngine templateEngine;

    @Test
    void sendMail() {
        mailClient.sendMail("zhaozhenyuwer@163.com","TEXT","welcome");
    }

    @Test
    void testHtmlMail() {
        // import org.thymeleaf.context.Context;
        // 利用 Context 对象，构造参数
        Context context = new Context();
        // 把参数存到 context 对象里
        context.setVariable("username","Sunday");

        // 调用模板引擎，生成动态网页，其实就是字符串，我们可以使用 String 接收下
        // 参数为 ：网页路径, 数据
        String content = templateEngine.process("/mail/demo",context);
        // 打印下看下内容是啥
        System.out.println(content);

        // 发送邮件
        mailClient.sendMail("zhaozhenyuwer@sina.com","Hello!Html",content);
    }
}