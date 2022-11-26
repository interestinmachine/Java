import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

@WebServlet("/message")
public class messageWall extends HttpServlet {

    // 用于读取请求并解析数据
    private ObjectMapper objectMapper = new ObjectMapper();
    // 用于存储信息
    // private List<Message> messages = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取整个消息列表中的元素，将其全部返回给客户端即可。
        // 此处我们使用 ObjectMapper 把 Java 对象，转换成 json 形式字符串
        List<Message> messageList = load();
        String jsonString = objectMapper.writeValueAsString(messageList);
        resp.setContentType("application/json; charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解析数据
        Message message = objectMapper.readValue(req.getInputStream(),Message.class);
        // 保存数据
        // messages.add(message);
        save(message);

        // 返回响应，主要告诉页面，信息是否存入成功
        // 因为内容比较简单，我就直接输出了
        resp.setContentType("application/json; charset=utf-8"); // 约定浏览器返回数据的格式与读取方式
        // 注意：如果不加上 setContentType，浏览器就会把下面返回的数据当作普通字符串来读取
        // 我们通过 setContentType，告诉浏览器数据是一个 json 形式的数据，jQuery 的 ajax 就会将数据转换成 json 形式
        resp.getWriter().write("{\"ok\": true}");
    }

    // 把当前的信息存到数据库中
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

    // 从数据库查询到记录
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
