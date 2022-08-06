package ThreadTest;

import java.util.Scanner;

public class Test16 {
    static class Counter {
        public int flag = 0;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (counter) {
                        //加上 synchronized 之后，此时针对 flag 的操作，也会读写内存了。
                        if (counter.flag != 0) {
                            break;
                        }
                    }
                }
                System.out.println("循环结束");
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                //让用书输入一个整数来替换 counter.flag 的值
                Scanner scanner = new Scanner(System.in);
                System.out.println("请输入一个整数：");
                counter.flag = scanner.nextInt();
            }
        };
        t2.start();
    }
}

