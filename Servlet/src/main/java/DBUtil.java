import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 期望通过这个类来完成数据库的建立连接的过程
// 建立连接需要使用 DataSource，并且一个程序有一个 DataSource 实例即可。此处我们使用 单例模式 来实现。
public class DBUtil {

    private static DataSource dataSource = null;

    private static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/messageWall?characterEncoding=utf8&useSSL=false");
            ((MysqlDataSource)dataSource).setUser("root");
            ((MysqlDataSource)dataSource).setPassword("1234");
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return (Connection) getDataSource().getConnection();
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        // 此处建议分开写 try catch
        // 保证及时反馈一个地方的 close 异常，而不会影响到其他的 close 的执行

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
