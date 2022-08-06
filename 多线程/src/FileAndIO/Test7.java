package FileAndIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 指定一个目录，扫描这个目录，找到文件名中包含指定字符的文件。
 * 并提示用户是否要删除这个文件，根据用户的输入决定是否删除
 */
public class Test7 {
    public static void main(String[] args) throws IOException {
        // 1、让用户指定一个带扫描的根目录 和 要查询的关键字
        System.out.println("请输入要扫描的根目录（绝对路径）：");
        Scanner scanner = new Scanner(System.in);
        String root = scanner.next();
        File rootDir = new File(root);
        if (!rootDir.isDirectory()) {
            System.out.println("你输入的路径错误，程序直接退出！");
            return;
        }

        System.out.println("请输入要查找文件名中包含的关键字：");
        String token = scanner.next();

        // 2、递归遍历目录
        // result 表示递归遍历的结果，就包含着所有带有 token 关键字的文件名
        List<File> result = new ArrayList<>();
        scanDir(rootDir, token, result);

        // 3、遍历 result，向用户是否要删除该文件，根据用户的输入决定是否删除
        for (File f : result) {
            System.out.println(f.getCanonicalFile() + " 是否要删除？（Y/N)");
            String input = scanner.next();
            if (input.equals("Y")) {
                f.delete();
            }
        }
    }

    // 递归来遍历目录，找出里面所有符合条件的文件
    private static void scanDir(File rootDir, String token, List<File> result) throws IOException {
        // list 返回的是一个文件名（String），使用 listFiles 直接得到 File 对象
        File[] files = rootDir.listFiles();
        if (files == null || files.length == 0) {
            // 当前目录是个空目录
            return;
        }
        for (File f : files) {
            if (f.isDirectory()) {
                // 如果当前文件是一个目录，就递归进行查找
                scanDir(f, token, result);
            } else {
                // 如果当前文件是一个普通文件，就判断这个文件名是否包含关键字
                if (f.getName().contains(token)) {
                    result.add(f.getCanonicalFile());
                }
            }
        }
    }
}

