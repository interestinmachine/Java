package ThreadTest;

class Count {
    volatile public int count; // count 变量为两个线程要自增的变量
    public void increase() {
        ++count;
    }
}

public class Test15 {
    public static Count count = new Count();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5_0000; i++) {
                count.increase();
            }
        });

        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 5_0000; i++) {
                count.increase();
            }
        });

        t1.start();
        t2.start();

        // 为了保证得到的count的结果，是两个线程执行完毕后的结果
        // 我们需要使用 join 来等待 线程 执行结束
        // 这样在 main 线程中，打印的 count 的 结果，才是两个线程对 count 的 自增最终结果
        // 因为 三个线程(t1,t2,main)之间关系 为 并发关系。
        // 如果不使用 join， main线程压根就不会等 t1 和 t2 自增完，直接输出count。
        // 使用 join 之后，只有 t1 和 t2 线程都结束了之后，main线程才能结束。
        t1.join(); // 先执行 t1.join，然后等待 t1 结束
        t2.join(); // 与 t1.join同理，再等待 t2 结束。

        System.out.println(count.count);
    }
}

