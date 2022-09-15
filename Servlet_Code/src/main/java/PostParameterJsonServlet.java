import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/PostParameterJson")
public class PostParameterJsonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = readyBody(req);

        resp.getWriter().write(body);
    }

    private String readyBody(HttpServletRequest req) throws IOException {
        InputStream inputStream = req.getInputStream();
        int contentLength = req.getContentLength();
        byte[] buffer = new byte[contentLength];
        inputStream.read(buffer);
        return new String(buffer,"utf-8");
    }
}

