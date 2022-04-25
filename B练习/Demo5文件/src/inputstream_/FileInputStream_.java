package inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        String filePath = "E:\\A开发学习及代码练习\\Java\\java-code-exercise\\B练习\\Demo5文件\\hello.txt";
        int read = 0;

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

