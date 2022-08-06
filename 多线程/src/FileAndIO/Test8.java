package FileAndIO;

import java.io.*;
import java.util.Scanner;

/**
 * 复制一个文件
 * 启动程序后，让用户输入一个文件的绝对路径，要求这个文件是一个普通文件，不是目录
 * 然后再指定一个要复制过去的目标目录。
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要复制的文件（绝对路径）：");
        String srcPath = scanner.next();
        File srcFile = new File(srcPath);
        if (!srcFile.isFile()) {
            System.out.println("文件路径错误，程序直接退出");
            return;
        }
        System.out.println("请输入要复制到的目标路径（绝对路径）：");
        String destPath = scanner.next();
        // 要求这个 destFile 必须不能存在
        File destFile = new File(destPath);
        if (destFile.exists()) {
            System.out.println("目标文件的路径已经存在！程序直接退出");
            return;
        }
        if (!destFile.getParentFile().exists()) {
            // 父级目录不存在，提示一个报错，也可以不存在就创建出目录
            System.out.println("目标文件的父目录不存在，程序直接退出");
            return;
        }

        // 具体进行复制操作
        // 复制操作就是打开待复制的文件，读取出每个字节，然后再把字节写入到目标文件中。
        try (InputStream inputStream = new FileInputStream(srcFile);
             OutputStream outputStream = new FileOutputStream(destFile)) {
            // 从 inputStream 中按照字节来读，然后把结果写入到 outputStream 中
            while (true) {
                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);
                if (len == -1) {
                    break;
                }
                outputStream.write(buffer,0,len);
            }
            // 如果这里不加 flush，触发 close 操作，也会自动刷新缓冲区
            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("复制完成！");
    }
}

