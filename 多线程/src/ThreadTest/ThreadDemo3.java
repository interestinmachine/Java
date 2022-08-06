package ThreadTest;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello Runnable!");
            }
        });
        thread.run();
    }
}

