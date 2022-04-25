package file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Directory_ {
    public static void main(String[] args) {

    }

    //判断 E:\A开发学习及代码练习\Java\java-code-exercise\B练习\Demo5文件\news1.txt 是否存在，如果存在就删除
    @Test
    public void m1() {
        String filePath = "E:\\A开发学习及代码练习\\Java\\java-code-exercise\\B练习\\Demo5文件\\news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该文件不存在");
        }
    }

    //判断 E:\A开发学习及代码练习\Java\java-code-exercise\B练习\Demo5文件\\demo_test 是否存在，存在就删除，否则提示不存在
    //在java中，目录也会被当成文件
    @Test
    public void m2() {
        String filePath = "E:\\A开发学习及代码练习\\Java\\java-code-exercise\\B练习\\Demo5文件\\demo_test";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该目录不存在");
        }
    }

    //判断 E:\A开发学习及代码练习\Java\java-code-exercise\B练习\Demo5文件\\a\\b\\c 目录是否存在，如果存在就提示已经存在
    //否则创建
    @Test
    public void m3() {
        String directoryPath = "E:\\A开发学习及代码练习\\Java\\java-code-exercise\\B练习\\Demo5文件\\a\\b\\c";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println(directoryPath + " 存在...");
        } else {
            if (file.mkdirs()) {
                System.out.println(directoryPath + " 创建成功...");
            } else {
                System.out.println(directoryPath + " 创建失败...");
            }
        }
    }
}



