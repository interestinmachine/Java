package ThreadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test27 {
    static class Worker extends Thread{
        private BlockingQueue<Runnable> queue = null;

        public Worker(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            // 工作线程具体的逻辑
            // 需要从阻塞队列中取任务
            while (true) {
                try {
                    Runnable command = queue.take();
                    // 通过 run 来执行这个具体的任务
                    command.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class MyThreadPool {
        // 包含一个阻塞队列，用来组织任务
        private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        private static final int maxWorkerCount = 10;

        // 这个list用来存放当前的工作线程
        private List<Thread> workers = new ArrayList<>();

        // 通过这个方法，把任务加入到线程池中。
        // submit 不光可以把任务放到阻塞队列，同时也可以负责创建线程。
        public void submit(Runnable command) throws InterruptedException {
            if (workers.size() < maxWorkerCount) {
                // 如果当前工作线程的数量不足线程数目上限，就创建出新的线程
                // 工作线程专门搞一个类来完成
                // Worker 内部要能够取到队列的内容，就需要把这个队列实例通过 Worker 的构造方法传过去。
                Worker worker = new Worker(queue);
                worker.start();
                workers.add(worker);
            }
            // 如果工作线程的数量超过上限，则只添加任务，不创建新的线程了
            queue.put(command);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool();
        // 加入10个任务
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello " + finalI);
                }
            });
        }
    }
}

