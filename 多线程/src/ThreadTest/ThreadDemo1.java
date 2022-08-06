package ThreadTest;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread executing");
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.run();
    }
}

