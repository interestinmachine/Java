package ThreadTest;

public class Test29 {
    static class Result {
        public int sum = 0;
        public final Object lock = new Object();
    }

    public static void main(String[] args) throws InterruptedException {
        Result result = new Result();
        Thread t = new Thread() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                synchronized (result.lock) {
                    result.sum = sum;
                    result.lock.notify();
                }
            }
        };
        t.start();
        synchronized (result.lock) {
            while (result.sum == 0) {
                result.lock.wait();
            }
            System.out.println(result.sum);
        }
    }
}

