package ThreadTest;

public class Test18 {
    static class WaitTask implements Runnable {
        private Object locker = null;

        public WaitTask(Object l) {
            this.locker = l;
        }

        @Override
        public void run() {
            synchronized (locker) {
                // 进行 wait 的线程
                System.out.println("wait 开始");
                try {
                    // 直接调用 wait，相当于 this.wait()，也就是针对 WaitTask 对象来进行等待
                    // 但是我们一会在 NotifyTask 中要求得针对同一个对象来进行通知，然而，在 NotifyTask
                    // 并没有那么容易拿到 WaitTask 实例
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait 结束");
            }
        }
    }

    static class NotifyTask implements Runnable {
        private Object locker = null;

        public NotifyTask(Object l) {
            this.locker = l;
        }

        @Override
        public void run() {
            // 进行 notify 的线程
            synchronized (locker) {
                System.out.println("notify 开始");
                locker.notifyAll();
                System.out.println("notify 结束");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 为了解决刚才的问题，专门创建一个对象，去负责进行加锁/通知操作
        Object locker = new Object();
        Thread t11 = new Thread(new WaitTask(locker));
        Thread t12 = new Thread(new WaitTask(locker));
        Thread t13 = new Thread(new WaitTask(locker));
        Thread t2 = new Thread(new NotifyTask(locker));
        t11.start();
        t12.start();
        t13.start();
        Thread.sleep(3000);
        t2.start();
    }
}

