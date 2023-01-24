package com.example.mycnblog_ssm.common;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

public class SecurityUtil {

    /**
     * 对密码进行加密、加盐操作
     * @param password
     * @return
     */
    public static String encrypt(String password) {
        // 每次生成内容不同的，但长度固定 32 位的盐值
        String salt = UUID.randomUUID().toString().replace("-","");
        // 最终密码=md5(盐值+原始密码)
        String finalPassword = DigestUtils.md5DigestAsHex((salt+password).getBytes());
        return salt + finalPassword;
    }

    /**
     *
     * @param password 待验证的密码
     * @param finalPassword 最终正确的密码（数据库中加盐的密码）
     * @return
     */
    public static boolean decrypt(String password,String finalPassword) {
        // 非空校验
        if (!StringUtils.hasLength(password) || !StringUtils.hasLength(finalPassword)) {
            return false;
        }

        if (finalPassword.length() != 64) {
            return false;
        }

        // 取盐值
        String salt = finalPassword.substring(0,32);
        String SecurityPassword = DigestUtils.md5DigestAsHex((salt+password).getBytes());

        return (salt+SecurityPassword).equals(finalPassword);
    }

    public static void main(String[] args) {
        String password = "123";
        System.out.println(SecurityUtil.decrypt(password,"9af513267b5c4785a043c1d7af1887290d38ff265b4c594dd4af06a5196092af"));
    }
}
