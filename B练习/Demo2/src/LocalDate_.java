import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDate_ {
    public static void main(String[] args) {
        //1. 使用now() 返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now();//LocalDate.now();//LocalTime.now();
        System.out.println(ldt);

        //2. 使用 DateTimeFormatter 对象来进行格式化
        // 创建 DateTimeFormatter 对象
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss E");
        String format = dtf.format(ldt);
        System.out.println(format);
    }
}

