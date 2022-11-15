import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 把自动生成的调用父类的方法要删掉，否则会有问题
        //super.doGet(req, resp);

        // 当前写一个 hello world!
        // 这个打印是打印在服务器的控制台上
        System.out.println("hello world!");

        // 这个打印就是打印在响应报文中，显示到页面上
        // 把 "hello world!" 字符串作为响应报文的 body 了，浏览器就会把这个 body 显示到页面中
        resp.getWriter().write("hello world!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        resp.getWriter().write("doPost");
    }
}
