package ThreadTest;

public class Test14 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                // 没有写代码的时候，线程是处于就绪状态
                try {
                    // 加上 sleep 之后，这里的代码大概率处于 睡眠状态
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        Thread.sleep(1000);
        System.out.println(t.getState());

    }
}

