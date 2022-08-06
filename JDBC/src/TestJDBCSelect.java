import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");

        Connection connection = dataSource.getConnection();

        String sql = "select * from JDBC";
        PreparedStatement statement = connection.prepareStatement(sql);

        // 执行 SQL，对于查询操作，就需要使用 executeQuery 了
        // 查询操作返回的不是一个 int 了，而是一个 “临时表”
        // 使用 ResultSet 表示这个表
        ResultSet resultSet = statement.executeQuery();

        // 遍历结果集合（返回的临时表），先获取到每一行，再获取到这一行中的若干列
        // next 方法表示获取到一行记录，同时把光标向后移动一行
        // 如果遍历列表的结束为止，此处的 next 直接返回 false 了
        //      +------+-----------+
        //      | id   | name      |
        //      +------+-----------+
        //     |    3 | 哈哈哈    |
        //     +------+-----------+
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id = " + id + " ,name = " + name);
        }

        resultSet.close();
        statement.close();
        connection.close();;
    }
}

