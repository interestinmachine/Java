package exit_;

public class ThreadExit {
    public static void main(String[] args) {
        T t = new T();
        t.start();

        //如果希望主线程控制 t 线程的终止，必须可以修改loop变量
        //让 t 退出run方法，从而终止 t 线程 -> 通知方式

        //让主线程休眠 10 秒，再通知 t 线程退出
        System.out.println("主线程休眠10s...");
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    //设置一个控制变量
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中...." + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
