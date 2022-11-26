package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 用这个 servlet 返回主页信息
@WebServlet("/index")
public class indexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 要做的工作，把当前用户信息展示到页面上
        HttpSession session = req.getSession(false);
        if (session == null) {
            // 用户未登录，则跳转到登录页面，要求用户重新登录
            resp.sendRedirect("login.html");
            return;
        }
        // 已经登录成功过，就会获取到会话中的数据
        // 由于 getAttribute 返回的是 Object，需要强转
        String username = (String)session.getAttribute("username");
        Integer visitCount = (Integer)session.getAttribute("visitCount");
        visitCount = visitCount+1;
        session.setAttribute("visitCount",visitCount);

        resp.setContentType("text/html; charset=utf8");
        resp.getWriter().write("当前用户为：" + username + " 访问次数："+visitCount);
    }
}
