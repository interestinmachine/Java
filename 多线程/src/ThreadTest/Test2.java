package ThreadTest;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello");
    }
}

public class Test2 {
    public static void main(String[] args) {
        // 需要注意的是 这里 我们实例化是 Thread 类本身，
        // 只不过构造方法里给指定了 MyRunnable 实例
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
