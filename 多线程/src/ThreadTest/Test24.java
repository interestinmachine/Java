package ThreadTest;

import java.util.Timer;
import java.util.TimerTask;

public class Test24 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        System.out.println("开始执行代码！");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("触发定时器！");
            }
        },3000);
    }
}

