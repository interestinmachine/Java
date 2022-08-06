package FileAndIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Test6 {
    public static void main(String[] args) {
        // 使用 PrintWriter 类来包装下 OutputStream，更方便的进行写数据
        try (OutputStream outputStream = new FileOutputStream("./test.txt")) {
            // 使用 PrintWriter 类来包装
            try (PrintWriter writer = new PrintWriter(outputStream)) {
                writer.println("HELLO WROLD，赵振宇");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

