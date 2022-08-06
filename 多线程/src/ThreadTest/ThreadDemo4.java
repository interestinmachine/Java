package ThreadTest;

public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"myThread");

        System.out.println(t.getId());
        System.out.println(t.getPriority());
        System.out.println(t.getState());
        System.out.println(t.getName());
        System.out.println(t.isDaemon());
        System.out.println(t.isAlive());

    }
}

