package FileAndIO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// 通过递归的方式，来罗列出指定目录中的所有文件路径
public class Test1 {
    public static List<String> result = new ArrayList<>();

    public static void getAllFiles(String basePath) {
        File file = new File(basePath);
        if (file.isFile()) {
            result.add(basePath);
            return;
        } else if (file.isDirectory()) {
            String[] files = file.list();
            for (String f : files) {
                getAllFiles(basePath + "/" + f);
            }
        } else {
            // 当前文件既不是普通文件，也不是目录，这个情况暂时不考虑
        }
    }

    public static void main(String[] args) {
        getAllFiles(".");
        for (String s : result) {
            System.out.println(s);
        }
    }
}

