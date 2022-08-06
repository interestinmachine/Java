package ThreadTest;


public class TestDemo7 {
    public static final long count = 10_0000_0000;

    public static void serial() {
        // 记录程序自增开始的时间
        long begin = System.currentTimeMillis();
        long a = 0;
        for (long i = 0; i < count; i++) {
            a++;
        }
        long b = 0;
        for (long i = 0; i < count; i++) {
            b++;
        }
        // 记录程序自增的结束时间
        long end = System.currentTimeMillis();
        System.out.println("单线程花费时间: " + (end - begin) + "ms");
    }

    public static void concurrency() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            long a = 0;
            for (long i = 0; i < count; i++) {
                a++;
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            long b = 0;
            for (long i = 0; i < count; i++) {
                b++;
            }
        });
        t2.start();

        // join的效果就是 等待线程结束
        t1.join(); // 让 main 线程等待 t1 线程执行结束
        t2.join(); // 让 main 线程等待 t2 线程执行结束
        long end = System.currentTimeMillis();
        System.out.println("多线程花费时间: " + (end-begin) + "ms");
    }

    public static void main(String[] args) throws InterruptedException {
        serial();
        concurrency();
    }
}

