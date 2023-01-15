package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class CommunityUtil {

    // 生成随机字符串
    public static String generateUUID() {
        // 随机字符串中可能有 - ，使用 replaceAll 将所有的 - 替换为空
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    // MD5 加密
    // 注册的时候提交的是明文，在我们保存的时候需要对其进行加密
    // 如对 hello 进行加密， hello -> abc123，每次加密hello都是abc123这个值，而且不能解密
    // 但是当密码过于简单的时候，密码是很容易被猜出来的。
    // 这时候我们可以在原密码的基础上再加上随机值，在进行加密，如 hello + ae86 -> as89ujopl
    // 上面加的随机值，在数据库中叫做 salt

    /**
     *
     * @param key 为 原密码 + salt
     * @return
     */
    public static String md5(String key) {
        // 进行判空
        // key 为null、空字符串、空格都认为是空的
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
