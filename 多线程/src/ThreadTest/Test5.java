package ThreadTest;

public class Test5 {
    public static void main(String[] args) {
        // () 表示无参数的 run 方法
        // -> 表示这是个 lambda 表达式
        // {lambda 表达式里面的内容}
        Thread t = new Thread(() -> {
            System.out.println("Hello Thread");
        });
        t.start();
    }
}

