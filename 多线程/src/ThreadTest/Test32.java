package ThreadTest;

import java.util.concurrent.Semaphore;

public class Test32 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 先尝试申请资源
                try {
                    System.out.println("准备申请资源");
                    semaphore.acquire();
                    System.out.println("申请资源成功");
                    // 申请到了之后， sleep 1000 ms
                    Thread.sleep(1000);
                    // 再释放资源
                    System.out.println("即将释放资源");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 创建 20 个线程
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}

