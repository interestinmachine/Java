package ThreadUse;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        //创建Cat对象，可以当做线程使用
        Cat cat = new Cat();
        cat.start();//启动线程
        //说明：当main线程启动一个子线程 Thread-0时，主线程不会阻塞，会继续执行

        System.out.println("主线程继续执行：" + Thread.currentThread().getName());//名字为main
        for(int i = 0; i < 60; i++) {
            System.out.println("主线程 i= " + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}

//1. 当一个类继承了 Thread 类，该类就可以当做线程使用
//2. 我们会重写 run 方法，写上自己的业务代码
//3. run Thread类实现了 Runnable 接口的run方法
/**
 *     @Override
 *     public void run() {
 *         if (target != null) {
 *             target.run();
 *         }
 *     }
 */
class Cat extends Thread {
    @Override
    public void run() { //重写 run 方法，写上自己的业务逻辑
        int time = 0;
        while (true) {
            //该线程每隔1秒，在控制台输出“喵喵，我是小猫咪”
            System.out.println("喵喵，我是小猫咪 " + Thread.currentThread().getName());
            ++time;
            //让线程休眠1秒,快捷键 ctrl + alt + t
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (time == 80) {
                break;//当执行了80次，退出循环，就退出了线程。
            }
        }
    }
}

