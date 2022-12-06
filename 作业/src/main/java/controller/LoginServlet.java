package controller;

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
        resp.setContentType("text/html; charset=utf8");
        // 读取请求中的参数，判断当前用户的身份信息是否正确
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || username.equals("") || password == null || password.equals("")) {

            resp.getWriter().write("用户名或密码不完整！登录失败！");
            return;
        }

        // 验证用户名和密码是否正确，一般来说这些东西是存在数据库的
        if (!username.equals("zhangsan") || !password.equals("123")) {
            // 登录失败
            resp.getWriter().write("用户名或密码错误！登录失败！");
            return;
        }

        // 登录成功
        // 需要一个 会话（session）把用户信息存进去
        HttpSession session = req.getSession(true);
        session.setAttribute("username","zhangsan");
        session.setAttribute("password","123");
        // 第二个参数是 Object，虽然写的是0，但是自动装箱成 Integer了，所以取的时候也是Integer
        Integer visitCount = (Integer)session.getAttribute("visitCount");
        if (visitCount == null) {
            session.setAttribute("visitCount",0);
        }

        // 页面跳转到登录页面
        resp.sendRedirect("index");
    }
}
