import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Message {
    public String from;
    public String to;
    public String message;
}

@WebServlet("/getMessage")
public class getMessage extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messageList = load();
        String jsonString = objectMapper.writeValueAsString(messageList);
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        Message message = objectMapper.readValue(req.getInputStream(),Message.class);
        save(message);
        resp.getWriter().write("ok");
    }

    private void save(Message message) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1. 和数据库建立连接
            connection = DBUtil.getConnection();
            // 2. 构造 SQL 语句
            String sql = "insert into messagewall.message values(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,message.from);
            statement.setString(2,message.to);
            statement.setString(3,message.message);
            // 3. 执行 sql 语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("插入失败！");
            } else {
                System.out.println("插入成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭连接
            DBUtil.close(connection,statement,null);
        }
    }

    private List<Message> load() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Message> messageList = new ArrayList<>();

        try {
            // 1. 建立连接
            connection = DBUtil.getConnection();
            // 2. 构造 sql 语句
            String sql = "select * from messageWall.message";
            statement = connection.prepareStatement(sql);
            // 3. 执行 sql
            resultSet = statement.executeQuery();
            // 4. 遍历结果集
            while (resultSet.next()) {
                Message message = new Message();
                message.from = resultSet.getString("from");
                message.to = resultSet.getString("to");
                message.message = resultSet.getString("message");

                messageList.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. 释放资源
            DBUtil.close(connection,statement,resultSet);
        }

        return messageList;
    }
}
