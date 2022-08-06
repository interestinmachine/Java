package ThreadTest;

public class Test9 {
    private static boolean isQuit = false;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            // isQuit 为 true 不执行输出语句
            // isQuit 为 false 执行输出语句
            while (!isQuit) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        // 只要把 isQuit 设为 true，线程t中的循环就会跳出，run就执行完毕了。
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isQuit = true;
        System.out.println("终止 t 线程");
    }
}

