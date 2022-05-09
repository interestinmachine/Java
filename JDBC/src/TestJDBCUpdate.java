import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBCUpdate {
    public static void main(String[] args) throws SQLException {
        //根据 id 来修改姓名，让用户输入要修改的 id ，以及对应的修改后的名字
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");

        Connection connection = dataSource.getConnection();

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要修改的 id ：");
        int id = scanner.nextInt();
        System.out.println("输入新名字：");
        String name = scanner.next();

        String sql = "update JDBC set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setInt(2,id);

        int ret = statement.executeUpdate();
        System.out.println("ret = " + ret);

        statement.close();
        connection.close();
    }
}

