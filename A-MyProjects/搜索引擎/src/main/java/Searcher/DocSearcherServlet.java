package Searcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searcher")
public class DocSearcherServlet extends HttpServlet {

    private static DocSearcher docSearcher = new DocSearcher();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("query");
        if (query == null || query.equals("")) {
            String msg = "参数缺失，未获取到 query 参数";
            System.out.println(msg);
            resp.sendError(404,msg);
            return;
        }
        System.out.println("查询词为：" + query);
        List<Result> results = docSearcher.search(query);
        resp.setContentType("application/json; charset=utf-8");
        objectMapper.writeValue(resp.getWriter(),results);
    }
}
