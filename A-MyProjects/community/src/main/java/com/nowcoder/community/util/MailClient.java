package com.nowcoder.community.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Component
public class MailClient {
    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);

    @Resource
    private JavaMailSender mailSender;

    // 将邮箱的用户名注入进来
    @Value("${spring.mail.username}")
    private String from;

    /**
     *
     * @param to 发给谁
     * @param subject 主题
     * @param content 内容
     */
    public void sendMail(String to, String subject, String content) {
        try {
            // 通过JavaMailSender源码可以看出，需要构建 MimeMessage
            MimeMessage message = mailSender.createMimeMessage();
            // 但是上面create出来的对象是个空的，我们还需要一个模板，填入内容
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            // 设置内容,如果不加html的参数，则只会认为content只是个文本。加了html=true，允许支持html文本的
            helper.setText(content, true);
            // 发送
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            logger.error("发送邮件失败：" + e.getMessage());
        }
    }

}
