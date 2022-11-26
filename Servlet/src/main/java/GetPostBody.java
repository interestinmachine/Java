import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class Some {
    public int aa;
    public int bb;
}

@WebServlet("/getPostBody")
public class GetPostBody extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Some some = objectMapper.readValue(req.getInputStream(),Some.class);
        resp.getWriter().write("aa = " + some.aa + " bb = " + some.bb);
    }
}
