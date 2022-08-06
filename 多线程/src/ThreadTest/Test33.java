package ThreadTest;

import java.util.concurrent.CountDownLatch;

public class Test33 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(8);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("起跑！");
                // random 方法得到一个 [0,1] 之间的浮点数
                // sleep 的单位是 ms，此处 * 10000 的意思是 sleep [0,10) 区间范围内的秒数
                try {
                    Thread.sleep((long)(Math.random() * 10000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println("撞线完成！");
            }
        };
        for (int i = 0; i < 8; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
        latch.await();
        System.out.println("比赛结束！");
    }
}

