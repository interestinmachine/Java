import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/showRequest")
public class ShowRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 把 api 的执行结果，放到 StringBuilder 中
        StringBuilder stringBuilder = new StringBuilder();

        // 首行部分
        stringBuilder.append("<h3> 首行部分</h3>");
        stringBuilder.append(req.getProtocol()); // 获取 版本协议
        stringBuilder.append("<br>"); // 换行

        stringBuilder.append(req.getMethod()); // 获取 请求方法
        stringBuilder.append("<br>"); // 换行

        stringBuilder.append(req.getRequestURI()); // 获取 请求路径
        stringBuilder.append("<br>"); // 换行

        stringBuilder.append(req.getContextPath()); // 获取 请求的第一级路径
        stringBuilder.append("<br>"); // 换行

        stringBuilder.append(req.getQueryString()); // 获取 完整的查询字符串
        stringBuilder.append("<br>"); // 换行

        // header 部分
        stringBuilder.append("<h3> header 部分</h3>");
        Enumeration<String> headerNames = req.getHeaderNames(); // 获取报头中所有 key 值
        // 使用迭代器方式来遍历 获取到的 header 中 key 值
        while (headerNames.hasMoreElements()) {
            // 获取到 headerNames 中的一个 key 元素
            String headerName = headerNames.nextElement();
            // 通过 header 中 key 值，获取到对应的 value
            String headerValue = req.getHeader(headerName);

            // 将 key 和 value 组成键值对，放入 stringbuilder
            stringBuilder.append(headerName + ": " + headerValue + "<br>");
        }

        //在展示结果之前，需要指定浏览器的读取编码的方式，防止乱码
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(stringBuilder.toString());
    }
}
