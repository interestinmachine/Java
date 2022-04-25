package ThreadUse;

public class Thread02 {
    public static void main(String[] args) {
//        Dog dog = new Dog();
//        //dog.start(); 这里不能调用start
//        //创建 Thread 对象，把 dog 对象（实现了Runnable）放入 Thread
//        Thread thread = new Thread(dog);
//        thread.start();

        Tiger tiger = new Tiger();//实现了Runnable
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}

class Animal {}
class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫。。。");
    }
}

//线程代理类，模拟了一个极简的Thread 类
class ThreadProxy implements Runnable {

    private Runnable target = null;//属性，类型是Runnable

    @Override
    public void run() {
        if (target != null) {
            target.run();
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();//这个方法是真正实现多线程的方法
    }

    public void start0() {
        run();
    }
}

class Dog implements Runnable {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("小狗汪汪叫..hi" + (++count) + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10){
                break;
            }
        }


    }
}
