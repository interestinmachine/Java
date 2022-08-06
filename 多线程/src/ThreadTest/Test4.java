package ThreadTest;

public class Test4 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Thread");
            }
        });
        t.start();
    }
}

