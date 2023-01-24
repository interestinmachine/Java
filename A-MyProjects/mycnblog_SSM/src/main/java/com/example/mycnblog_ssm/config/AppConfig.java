package com.example.mycnblog_ssm.config;

import com.example.mycnblog_ssm.common.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    // 不拦截的 url 集合
    List<String> excludes = new ArrayList<String>() {{
        add("/**/*.html");
        add("/js/**");
        add("/editor.md/**");
        add("/css/**");
        add("/img/**");
        add("/user/login");
        add("/user/reg");
        add("/user/myinfobyuid");
        add("/article/list");
        add("/article/totalpage");
        add("/article/detail");
    }};

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration =
                registry.addInterceptor(loginInterceptor);
        //registration.addPathPatterns("/**");
        registration.excludePathPatterns("/**");
    }
}
