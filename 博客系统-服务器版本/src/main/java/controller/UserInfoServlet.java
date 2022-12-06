package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userinfo")
public class UserInfoServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String blogId = req.getParameter("blogId");
        // 请求来自博客列表页，直接返回登录的用户信息
        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");
        if (blogId == null) {

            if (session == null) {
                resp.setStatus(403);
                resp.setContentType("text/html; charset=utf8");
                resp.getWriter().write("当前未登录！");
                return;
            }

            if (user == null) {
                resp.setStatus(403);
                resp.setContentType("text/html; charset=utf8");
                resp.getWriter().write("当前未登录！");
                return;
            }

            // 响应中最好不要带有密码
            user.setPassword("");
            resp.setContentType("application/json; charset=utf8");
            String jsonString = objectMapper.writeValueAsString(user);
            resp.getWriter().write(jsonString);
        } else {
            // 请求来自博客详情页，返回文章作者信息
            BlogDao blogDao = new BlogDao();
            Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
            if (blog == null) {
                resp.setStatus(403);
                resp.setContentType("text/html; charset=utf8");
                resp.getWriter().write("当前 blogId 有误！");
                return;
            }

            UserDao userDao = new UserDao();
            User author = userDao.selectByUserId(blog.getUserId());
            if (author == null) {
                resp.setStatus(403);
                resp.setContentType("text/html; charset=utf8");
                resp.getWriter().write("当前博客对应的作者没有找到！");
                return;
            }
            // 响应中最好不要带有密码
            author.setPassword("");
            // 校验下，当前的用户是否是博客的作者
            if (user.getUserId() == author.getUserId()) {
                author.setIsYourBlog(1);
            } else {
                author.setIsYourBlog(0);
            }
            resp.setContentType("application/json; charset=utf8");
            String jsonString = objectMapper.writeValueAsString(author);
            resp.getWriter().write(jsonString);

        }
    }
}
