package excise_;

public class Homework02 {
    public static void main(String[] args) {
        T1 t = new T1();
        Thread thread = new Thread(t);
        thread.setName("A");
        Thread thread2 = new Thread(t);
        thread2.setName("B");
        thread.start();
        thread2.start();
    }
}

class T1 implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }

                money -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取钱， 余额 = " + money);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}