package method_;

public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("zzy");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();//启动子线程

        System.out.println(t.getName());

        //主线程打印hi，然后中断子线程的休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }
        System.out.println(t.getName() + " 线程的优先级 = " + t.getPriority());

        t.interrupt();//当执行带这里，就会中断 t 线程的休眠
    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100; i++) {
                //Thread.currentThread().getName() 获取当前线程的名称
                System.out.println(Thread.currentThread().getName() + " 吃包子~~" + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                //当该线程执行到一个interrupt 方法时，就会catch一个异常，可以加入自己的业务代码
                System.out.println(Thread.currentThread().getName() + " 被 interrupt 了~~~");
            }
        }
    }
}

