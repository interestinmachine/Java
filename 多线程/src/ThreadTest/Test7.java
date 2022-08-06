package ThreadTest;

public class Test7 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread1");
        t.start();

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("hello Thread2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread2");
        t2.start();
    }
}

