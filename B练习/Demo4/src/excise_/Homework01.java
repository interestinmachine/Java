package excise_;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();

    }
}

class A extends Thread {
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println((int)(Math.random()*100 + 1));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread{
    private A a;
    Scanner scanner = new Scanner(System.in);

    public B(A a){
        this.a = a;
    }

    @Override
    public void run() {
        //接受到用户的输入
        while (true) {
            System.out.println("请输入你的指令（Q表示退出)：");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q'){
                //以通知的方式结束A线程
                a.setLoop(false);
                System.out.println("B线程退出 ");
                break;
            }
        }
    }

}
