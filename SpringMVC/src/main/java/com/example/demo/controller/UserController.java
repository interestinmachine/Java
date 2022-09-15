package com.example.demo.controller;

import com.example.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@Slf4j
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/reg")
    public String reg(@RequestBody UserInfo userInfo) {
        return "用户信息：" + userInfo;
    }

    @RequestMapping("/hero/{id}/{name}")
    public String getHeroInfo(@PathVariable Integer id,@PathVariable String name) {
        return "ID: " + id + " | Name: " + name;
    }

    // 从配置文件中读取图片的保存路径
    @Value("${img.path}")
    private String imgPath;

    @GetMapping("/sayhi")
    public String sayHi() {
        return "Hello World! " + imgPath;
    }

    @RequestMapping("/upimg")
    public boolean upImg(Integer id, @RequestPart("img")MultipartFile file) {
        boolean result = false;
        // 先获取图片名称
        String fileName = file.getOriginalFilename();
        // 从最好一个 . 位置，向后截取 剩余部分（获取文件格式）
        fileName = fileName.substring(fileName.lastIndexOf("."));
        // 利用 UUID 对 文件名称 进行处理，得到唯一的文件名称
        // 处理：生成唯一的随机数，与 文件后缀 进行拼接
        // 最终的结果 就是 文件的名称
        fileName = UUID.randomUUID().toString() + fileName;
        try {

            file.transferTo(new File(imgPath + fileName));
            result = true;
        } catch (IOException e) {
            log.error("图片上传失败：" + e.getMessage());
        }

        return result;
    }

    @RequestMapping("/cookie")
    public void getCookie(HttpServletRequest request) {
        // 得到全部的 Cookie
        Cookie[] cookies = request.getCookies();
        for(Cookie item:cookies) {
            log.info("Cookie Name: " + item.getName() +
                    "Cookie Value: " + item.getValue());
        }
    }

    @RequestMapping("/cookie2")
    public String cookie2(@CookieValue("zzy") String cookie_value) {
        return "Cookie Value: " + cookie_value;
    }

    @RequestMapping("/getua")
    public String getHead(HttpServletRequest request) {
        return "header: " + request.getHeader("User-Agent");
    }

    @RequestMapping("/getua2")
    public String getHead2(@RequestHeader("User-Agent") String userAgent) {
        return "header: " + userAgent;
    }

    @RequestMapping("/setsession")
    public boolean setSession(HttpServletRequest request) {
        boolean result = false;
        // 1. 先获取到 HttpSession 对象
        // 获取 session 对象时，参数必须置为 true（默认值为false）
        // true 的意思，如果会话不存在，则创建一个会话
        HttpSession session = request.getSession(true);
        //2. 使用 setAttribute 方法来设置会话属性
        session.setAttribute("userInfo","userInfoValue");
        result = true;
        return result;
    }

    @RequestMapping("/getsession")
    public String getSession(HttpServletRequest request) {
        String result = null;
        // 获取 session 对象
        // fasle表示会话不存在，就不在创建会话了
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userInfo") != null) {
            // 因为获取的 value 值是一个 object 类型，所以需要类型转换
            result = (String)session.getAttribute("userInfo");
        }
        return result;
    }

    @RequestMapping("getsession2")
    public String getSession2(@SessionAttribute(value = "userInfo",required = false) String str) {
        return "注解方式： "  + str;
    }

    @RequestMapping("/login2")
    public HashMap<String,Object> login2(String username,String password) {
        HashMap<String,Object> result = new HashMap<>();//记录返回的结果
        int state = -1; // 状态记录
        int data = -1; // 如果 data 为 1，则登录成功，否则失败
        String msg = "未知错误"; // 错误信息

        // spring 中提供了一个 StringUtils 类，里面提供了一个判空方法 hasLength
        // hasLength 能判断字符串是否为空，或者为 null
        // 如果不为空，也不为 null。则返回一个 true，反之false
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
            if (username.equals("admin") && password.equals("admin")) {
                state = 200;
                data = 1;
                msg = "";
            } else { // 用户名或密码错误
                msg = " 用户名或密码错误";
            }
        } else { // 参数为空
            msg = "非法参数";
        }
        result.put("state",state);
        result.put("data",data);
        result.put("msg",msg);

        return result;
    }
}
