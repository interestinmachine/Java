package ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test26 {
    public static void main(String[] args) {
        // 创建一个固定线程数目的线程池，参数指定了线程个数 【最常用的版本】
        ExecutorService service =  Executors.newFixedThreadPool(10);

        for (int i = 0; i < 50; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello ThreadPool!!");
                }
            });
        }

    }
}

