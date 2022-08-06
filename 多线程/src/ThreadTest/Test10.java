package ThreadTest;

public class Test10 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            // Thread.currentThread() 获取目前所在线程 t
            // isInterrupted() 判断 线程 t 是否中断
            // 中断返回 true，再根据 ！取反，为 false，跳出循环，从而结束 run任务，致使线程t中断结束执行
            // 执行中返回 false，，再根据 ！取反，为 true，执行 run 的 输出语句。
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
        t.start();

        try {
            Thread.sleep(5000); // 在 main 线程中，5s之后，执行下面的代码t.interrupt()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 在 main线程中，调用 interrupt 来中断 t 线程
        t.interrupt();
    }
}

