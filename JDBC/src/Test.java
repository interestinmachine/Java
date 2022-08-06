import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {

    volatile static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i =0;i <10000;i++) {
                    ++count;
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i =0;i <10000;i++) {
                    ++count;
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(count);
    }
}

