package excise_;

public class ThreadMethodExcise {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        Thread thread = new Thread(t);

        for(int i = 1; i <= 10; i++) {
            System.out.println("hi " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 5) {
                 thread.start();
                 thread.join();
            }
        }
        System.out.println("主线程结束...");
    }
}

class T implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("hello " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("子线程结束...");
    }
}
