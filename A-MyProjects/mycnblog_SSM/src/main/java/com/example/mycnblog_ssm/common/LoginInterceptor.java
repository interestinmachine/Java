package com.example.mycnblog_ssm.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            return true;
        }
        //System.out.println(session);
        System.out.println("触发 LoginInterceptor 中 的 401");
        response.setStatus(401);
        return false;
    }
}
