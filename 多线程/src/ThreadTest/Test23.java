package ThreadTest;

public class Test23 {
    static class BlockingQueue {
        // 1000 就相当于队列的最大容量了，此处暂时不考虑扩容的问题
        private int[] items = new int[1000];
        private int head = 0;
        private int tail = 0;
        private int size = 0;

        // put 用来入队列
        public void put(int item) throws InterruptedException {
            synchronized (this) {
                // 入队列，就把新的元素给放到 tail 位置上
                // 此处的条件最好写成 while，而不是 if
                // 如果是有多个线程阻塞等待的时候，万一同时唤醒了多个线程，
                // 就有可能出现：第一个线程放入元素之后（队列满了），第二个线程继续放入元素，队列已经满了。
                // 虽然当前 take 代码中使用的是 notify，一次只唤醒一个等待的线程，用 if 也不算错，
                // 但是，使用 while 更稳健些，
                // 使用 while 的意思就是，保证 wait 被唤醒的时候能够再确认一次队列确实不满。
                while (size == items.length) {
                    // 队列已经满了
                    // 对于阻塞队列来说就要阻塞
                    wait();
                }
                items[tail] = item;
                tail++;
                // 如果到达末尾，就回到起始位置
                if (tail >= items.length) {
                    tail = 0;
                }
                size++;
                notify();
            }
        }

        // take 用来出队列
        public int take() throws InterruptedException {
            int ret = 0;
            synchronized (this) {
                while (size == 0) {
                    // 对于阻塞队列来书，如果队列为空，再尝试读取元素，就要阻塞
                    wait();
                }
                ret = items[head];
                head++;
                if (head >= items.length) {
                    head = 0;
                }
                size--;
                // 此处的 notify 用来唤醒 put 中的 wait
                notify();
            }
            return ret;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new BlockingQueue();
        // 消费者线程
        Thread customer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int elem = queue.take();
                        System.out.println("消费元素：" + elem);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        customer.start();

        // 生产者线程
        Thread producer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    for (int i = 1; i < 10000; i++) {
                        System.out.println("生产元素：" + i);
                        try {
                            queue.put(i);
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        producer.start();

        customer.join();
        producer.join();
    }
}

