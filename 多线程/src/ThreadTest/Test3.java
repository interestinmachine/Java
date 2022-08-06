package ThreadTest;

public class Test3 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("hello Thread");
            }
        };
        t.start();
    }
}

