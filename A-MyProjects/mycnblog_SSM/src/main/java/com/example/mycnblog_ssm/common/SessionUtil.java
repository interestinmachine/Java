package com.example.mycnblog_ssm.common;

import com.example.mycnblog_ssm.model.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static UserInfo getLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            return  (UserInfo) session.getAttribute(Constant.SESSION_USERINFO_KEY);
        }
        return null;
    }
}
