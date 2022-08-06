package ThreadTest;

public class ThreadDemo6 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                int count = 0;
                while (count < 5) {
                    System.out.println("线程运行中...");
                    ++count;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();

        try {
            System.out.println("join执行开始");
            t.join();
            System.out.println("join执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

