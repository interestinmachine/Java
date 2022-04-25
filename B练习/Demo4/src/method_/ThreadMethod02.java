package method_;

import sun.security.krb5.internal.TGSRep;

public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();

        for (int i = 1; i <= 20; i++) {
            Thread.sleep(1000);
            System.out.println("主线程 吃了 " + i + " 包子");
            if(i == 5) {
                System.out.println("主线程让子线程先吃");
                //Thread.yield();
                t2.join();//这里相当于让 t2 线程执行完毕
                System.out.println("子线程吃完了，主线程接着吃");
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程 吃了 " + i + " 包子");
        }
    }
}

