import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 我们手动从浏览器传来这样的一个请求：/getParameter/userId=1&classId=2
        // 这里的查询字符串 userId=1&classId=2 就是键值对的结构
        // 这里我们希望根据 key，拿到对应的 value
        String userId = req.getParameter("userId"); // key 值需要和请求中的相匹配，才能获取对应的 value 值
        String classId = req.getParameter("classId");

        // 打印数据
        resp.getWriter().write("userId: " + userId + " classId: " + classId);
    }

}
