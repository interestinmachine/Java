package FileAndIO;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test5 {
    public static void main(String[] args) {
        // 会把原来文件里的内容清空
        try (OutputStream outputStream = new FileOutputStream("./test.txt")) {
            // 写入一个字符
            // outputStream.write('c');

            // 按照字节写入byte[] buffer = new byte[] {
            ////                    (byte)'a',(byte)'b'
            ////            };
            ////            outputStream.write(buffer);
//
            // 按照字符串写入
            String s = "hello world";
            outputStream.write(s.getBytes()); // 将字符串转成字节
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

