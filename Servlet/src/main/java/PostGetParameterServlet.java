import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/postGetParameter")
public class PostGetParameterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 加入前端传过来的参数是 userId=1&classId=2
        // 此时服务器也是通过 req.getParameter 来获取参数的
        resp.setContentType("text/html; charset=utf-8"); // 指定浏览器读取方式
        String userId = req.getParameter("userId");
        String classId = req.getParameter("classId");
        resp.getWriter().write("userId = " + userId + " classId = " + classId);
    }
}
