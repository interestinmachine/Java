import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class Student {
    public int userId;
    public int classId;
}

@WebServlet("/postGetParameter2")
public class PostJsonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建一个 Jackson 的核心对象
        ObjectMapper objectMapper = new ObjectMapper();

        // 从请求的 body 中进行读取，并解析
        // 使用 readValue 来吧 json 字符串转成 Java 对象
        // 第一个参数是一个 String 或者是一个 InputStream
        // 第二个参数是转换的结果对应的 java 类对象
        Student student = objectMapper.readValue(req.getInputStream(),Student.class);
        resp.getWriter().write(student.userId+", " + student.classId);
    }
}
