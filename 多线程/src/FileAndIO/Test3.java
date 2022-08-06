package FileAndIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// 一次读取多个字节
public class Test3 {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("./test.txt")) {
            byte[] buffer = new byte[1024];
            while (true) {
                int len = inputStream.read(buffer);
                if (len == -1) {
                    break;
                }
                for (int i = 0; i < len; i++) {
                    System.out.printf("%c",buffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

