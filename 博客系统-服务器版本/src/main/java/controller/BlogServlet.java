package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        String blogId = req.getParameter("blogId");
        BlogDao blogDao = new BlogDao();
        if (blogId == null) {
            List<Blog> blogs = blogDao.selectAll();
            String jasonString = objectMapper.writeValueAsString(blogs);
            resp.getWriter().write(jasonString);
        } else {
            // 存在 blogId 参数，就是获取博客详细
            Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
            String jsonString = objectMapper.writeValueAsString(blog);
            resp.getWriter().write(jsonString);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        // 1. 获取当前登录用户的休息
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(403);
            return;
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.setStatus(403);
            return;
        }

        // 2. 获取请求的内容
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (title == null || content == null || title.equals("") || content.equals("")) {
            resp.setStatus(400);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("请求中的标题或正文不完整");
            return;
        }

        // 3. 构造 Blog 对象，并插入数据库中
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUserId(user.getUserId());
        BlogDao blogDao = new BlogDao();
        blogDao.insert(blog);

        // 4. 插入成功后，跳转到博客列表页
        resp.sendRedirect("blog_list.html");
    }
}
