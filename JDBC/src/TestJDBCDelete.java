import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCDelete {
    public static void main(String[] args) throws SQLException {
        //删除数据库中的记录
        //让用户输入一个 id，根据 id 来删除
        //1. 创建数据库
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");

        //2. 建立连接
        Connection connection = dataSource.getConnection();

        //3. 用户输入 id
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个要删除的 id ：");
        int id = scanner.nextInt();

        //4. 拼装 sql 语句
        String sql = "delete from JDBC where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);

        //5. 执行 sql
        int ret = statement.executeUpdate();
        System.out.println("ret = " + ret);

        //6. 释放资源
        statement.close();
        connection.close();

    }
}

