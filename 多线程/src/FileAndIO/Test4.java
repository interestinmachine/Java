package FileAndIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        // 尝试从文件中读取出中文，借助标准库中内置的处理字符集的方式
        // Scanner 不光能从控制台读取标准输入，也可以从文件中读取数据
        try (InputStream inputStream = new FileInputStream("./test.txt")) {
            // Scanner 里面也有个 close 方法，这个 close 其实就是用来关闭 Scanner 内包含的 InputStream
            try (Scanner scanner = new Scanner(inputStream,"UTF-8")) {
                while (scanner.hasNext()) {
                    String s = scanner.next();
                    System.out.println(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

