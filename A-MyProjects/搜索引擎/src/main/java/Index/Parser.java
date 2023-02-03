package Index;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parser {

    // 指定一个加载文档的路径
    private static final String INPUT_PATH = "E:\\Coding\\Java\\docs\\api\\";

    private Index index = new Index();

    // 多线程执行 run 方法，减少解析文档的耗时
    public void runByThread() throws InterruptedException {
        long beg = System.currentTimeMillis();
        System.out.println("索引制作开始！");

        // 1. 枚举出所有文件
        ArrayList<File> files = new ArrayList<>();
        enumFile(INPUT_PATH,files);
        // 2. 循环遍历文件，此处为了能够通过多线程制作索引，就直接引入线程池
        CountDownLatch latch = new CountDownLatch(files.size());
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (File f:files) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("解析：" + f.getAbsolutePath());
                    parserHTML(f);
                    latch.countDown();
                }
            });
        }
        // await 方法会阻塞，直到所有线程都调用 countDown 之后，才能阻塞结束。
        latch.await();
        // 手动干掉线程池里的线程
        executorService.shutdown();

        // 3. 保存索引
        index.save();
        long end = System.currentTimeMillis();
        System.out.println("索引制作完毕，耗时：" + (end-beg) + " ms");
    }

    public void run() {
        // 整个 Index_module.Parser 类的入口
        // 1. 根据上面指定的路径，枚举出所有的文件(html)，这个过程需要把所有子目录中的文件都能获取到
        long beg = System.currentTimeMillis();
        ArrayList<File> filelist = new ArrayList<>();
        enumFile(INPUT_PATH, filelist);
        long endEnumFile = System.currentTimeMillis();
        System.out.println("枚举文件耗时：" + (endEnumFile-beg) + " ms");

        // 2. 针对上面罗列出的文件路径，打开文件，读取文件内容，并进行解析，并构建索引
        for (File f : filelist) {
            System.out.println("开始解析：" + f.getAbsolutePath());
            // 通过这个方法来解析单个 HTML 文件
            parserHTML(f);
        }
        long endParserHTML = System.currentTimeMillis();
        System.out.println("解析 HTML 文件耗时：" + (endParserHTML-endEnumFile) + " ms");

        System.out.println("所有程序耗时：" + (endParserHTML-beg) + " ms");

        // 3.把在内存中构造好的索引数据结构，保存到指定的文件中。
        index.save();
    }

    private void parserHTML(File f) {
        // 1. 解析出 HTML 的标题
        String title = parserTitle(f);
        // 2. 解析出 HTML 对应的 URL
        String url = parserURL(f);
        // 3. 解析出 HTML 对应的正文（有了正文才有后续的描述）
        String content = parserContentByRegex(f);
        // 4. 把解析出来的这些信息，加入到索引当中
        index.addDoc(title,url,content);
    }

    public String parserContent(File f) {
        // 先按照一个字符一个字符的方式来读取，以 < 和 > 来控制拷贝数据的开关
        // 手动把缓冲区设置 1 M 大小
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f),1024*1024)) {
            // 加上一个是否要进行拷贝的开关
            boolean isCopy = true;
            // content 用来存储结果
            StringBuilder content = new StringBuilder();

            while (true) {
                // 注意，此处的 read，返回值是一个 int，而不是 char ！
                // 此处使用 int 作为返回值，主要为了表示一些非法情况！
                // 如果读到文件末尾，继续读，就会返回 -1
                int ret = bufferedReader.read();
                if (ret == -1) {
                    // 表示文件读完了
                    break;
                }
                // 如果 ret 不为 -1，则为一个合法的字符
                char c = (char)ret;
                // 开关打开的状态，遇到普通字符拷贝到 StringBuilder 中
                if (isCopy) {
                    if (c == '<') {
                        // 关闭开关
                        isCopy = false;
                        continue;
                    }

                    if (c == '\n' || c == '\r') {
                        // 为了去掉换行，把换行替换成空格
                        c = ' ';
                    }
                    content.append(c);
                } else {
                    if (c == '>') {
                        isCopy = true;
                    }
                }
            }
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    // 此方法基于正则表达式，实现去标签，就是去除 script
    public String parserContentByRegex(File f) {
        // 1. 把整个文件都读到 String 里面
        String content = readFile(f);
        // 2. 替换掉 script 标签
        content = content.replaceAll("<script.*?>(.*?)</script>"," ");
        // 3. 替换掉普通的 html 标签
        content = content.replaceAll("<.*?>"," ");
        // 4. 使用正则把多个空格合成一个
        content = content.replaceAll("\\s+"," ");
        return content;
    }

    private String readFile(File f) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(f))) {
            StringBuilder content = new StringBuilder();
            while (true) {
                int ret = bufferedReader.read();
                if (ret == -1) {
                    break;
                }
                char c = (char) ret;
                if (c == '\n' || c == '\r') {
                    c = ' ';
                }
                content.append(c);
            }
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String parserURL(File f) {
        String part1 = "https://docs.oracle.com/javase/8/docs/api/";
        String part2 = f.getAbsolutePath().substring(INPUT_PATH.length());
        return part1 + part2;
    }

    private String parserTitle(File f) {
        String name = f.getName();
        return name.substring(0, name.length() - ".html".length());
    }

    private void enumFile(String inputPath, ArrayList<File> filelist) {
        File rootPath = new File(inputPath);
        // 使用 listFiles 只能看到一级目录，看不到子目录
        File[] files = rootPath.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                enumFile(file.getAbsolutePath(), filelist);
            } else {
                if (file.getAbsolutePath().endsWith(".html")) {
                    filelist.add(file);
                }
            }
        }
    }
}
