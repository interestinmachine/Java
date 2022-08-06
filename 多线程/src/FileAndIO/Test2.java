package FileAndIO;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

// 一次读取一个字节
public class Test2 {
    // 写法二：推荐写法，使用 try with resources，inputStream.close() 命令会自动在 try里面执行
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("./test.txt")){
            while (true) {
                int b = inputStream.read();
                if (b == -1) {
                    break;
                }
                System.out.printf("%c",b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 写法一：
    public static void main1(String[] args) throws IOException {
        // 创建实例的过程，就相当于在打开文件
        // 要先打开文件，然后才能进行读写
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("./test.txt");
            // 逐个字节的方式把文件内容读取出来
            while (true) {
                // 每次调用 read 就可以读取一些数据出来
                // read 提供了好几个版本，其中无参数版本就是一次读取一个字节
                // 对于无参数版本的 read，返回值就是这次操作读到的字节
                // 这个结果的范围就是 0~255
                // 如果读到文件末尾（EOF），此时继续进行 read，就会返回 -1
                int b = inputStream.read();
                if (b == -1) {
                    break;
                }
                System.out.printf("%c",b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

