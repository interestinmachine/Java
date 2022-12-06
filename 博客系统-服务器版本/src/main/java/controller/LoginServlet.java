package controller;

import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        // 1. 从请求中拿到用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || password == null || username.equals("") || password.equals("")) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("你当前的用户名或密码为空！");
            return;
        }

        // 2. 查询数据库，查看密码是否匹配
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(username);
        if (user == null) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("你的用户名和密码错误！");
            return;
        }

        if (!user.getPassword().equals(password)) {
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("你的用户名和密码错误！");
            return;
        }

        // 3. 登录成功后，构造会话
        HttpSession session = req.getSession(true);
        // 把刚才获取道德 user 对象给存到 session 里，方便后续使用
        session.setAttribute("user",user);

        // 4. 返回一个重定向报文，跳转到博客列表页
        resp.sendRedirect("blog_list.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 验证登录状态
        // 直接去取登录状态，看能不能取到
        HttpSession session = req.getSession(false);
        if (session == null) {
            // 未登录，直接设置状态码 403 即可，body 都不需要
            resp.setStatus(403);
            return;
        }

        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 未登录，直接设置状态码 403 即可，body 都不需要
            resp.setStatus(403);
            return;
        }

        // 已登录
        resp.setStatus(200);
    }
}
