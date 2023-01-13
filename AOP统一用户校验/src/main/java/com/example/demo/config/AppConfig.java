//package com.example.demo.config;
//
//import com.example.demo.aop.LoginInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class AppConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//    // 添加拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**") // 拦截所有接口
//                .excludePathPatterns("/user/login")
//                .excludePathPatterns("/user/index");// 排除接口
//
//    }
//
////    @Override
////    public void configurePathMatch(PathMatchConfigurer configurer) {
////        configurer.addPathPrefix("api",c -> true);
////    }
//}
