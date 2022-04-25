package method_;

import ThreadUse.Thread03;

public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如果我们希望当main线程结束后，子线程自动结束
        //只需将子线程设置为守护线程即可
        myDaemonThread.setDaemon(true);//要在start前设置
        myDaemonThread.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("主线程正在运行....hhhh  " + i);
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程正在运行...");
        }
    }
}

