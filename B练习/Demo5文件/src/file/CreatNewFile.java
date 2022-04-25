package file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * 演示创建文件
 */
public class CreatNewFile {
    public static void main(String[] args) {

    }

    @Test
    //方式一：new File(String pathname)
    public void creat01() {
        String filePath = "E:\\A开发学习及代码练习\\Java\\java-code-exercise\\B练习\\Demo5文件\\news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式二：new File(File parent,String child)
    @Test
    public void create02() {
        File pathFile = new File("E:\\A开发学习及代码练习\\Java\\java-code-exercise\\B练习\\Demo5文件\\");
        String fileName = "news2.txt";
        //这里的file对象，在java程序中，只是一个对象
        //只有执行了createNewFile方法，才会真正的在磁盘创建该对象
        File file = new File(pathFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式三：new File(String parent,String child)
    @Test
    public void create03() {
        String parentPath = "E:\\A开发学习及代码练习\\Java\\java-code-exercise\\B练习\\Demo5文件\\";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

