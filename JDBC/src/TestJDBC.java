import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        //让用户手动输入数据到数据库中
        Scanner scanner = new Scanner(System.in);

        //1. 创建数据源
        DataSource dataSource = new MysqlDataSource();

        //设置数据库所在的地址
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
        //设置登录数据库的用户名
        ((MysqlDataSource)dataSource).setUser("root");
        //设置登录数据库的密码
        ((MysqlDataSource)dataSource).setPassword("1234");

        //2. 让代码和数据库服务器之间建立连接
        Connection connection = dataSource.getConnection();

        //3. 操作数据库，以插入数据为例
        //   关键所在：构造一个 SQL 语句
        //   在 JDBC 中构造 SQL 语句，不必带上 ;
        //   ; 只是在命令行中用来区分不同的语句，现在是直接在代码中操作
        String sql = "insert into JDBC values(1,'张三')";
        // 此处光是一个 String 类型的 sql 还不行，需要把这个 String 包装成一个 “语句对象”
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //用户手动输入数据
        System.out.println("请输入 ID：");
        int id = scanner.nextInt();
        System.out.println("请输入 姓名：");
        String name = scanner.next();

        //? 相当于告诉 java程序，这两个字段的值 还不确定，此时就使用 ? 先占个位置
        // 再使用 PreparedStatement 的 setXXX 方法 进行替换，这里的setXXX方法很多，需要让这里的方法和数据库的列的类型匹配
        String sql2 = "insert into JDBC values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql2);
        //进行替换操作
        statement.setInt(1,id); //下标从 1 开始计算，把第一个 ? 替换成 id 这样的值
        statement.setString(2,name);
        System.out.println("statement: " + statement); //通过这个打印操作，可以看到拼装好之后的 SQL 长啥样

        //4. 执行 SQL
        //      SQL 里面如果是 insert, update, delete ，都使用 executeUpdate 方法，
        //      SQL 里面如果是 select,则使用 executeQuery 方法
        //      返回值就表示这个操作，影响到了几行，就相当于在控制台里输入 sql 之后，得到的数字
        int ret =  preparedStatement.executeUpdate();
        int ret2 = statement.executeUpdate();
        System.out.println(ret);
        System.out.println(ret2);

        //5. 此时 SQL 已经执行完毕，然后还需要释放资源
        preparedStatement.close();
        statement.close();
        connection.close();
    }
}

