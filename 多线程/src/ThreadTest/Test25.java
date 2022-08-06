package ThreadTest;

import java.sql.Time;
import java.util.concurrent.PriorityBlockingQueue;

public class Test25 {
    static class Task implements Comparable<Task>{
        // command 表示这个任务是啥
        private Runnable command;
        // time 表示这个任务啥时候到时间
        // 这里的 time 使用 ms 级的时间戳来表示
        private long time;

        // 约定参数 time 是一个时间差（类似于 3000）
        // 希望 this.time 来保存一个绝对的时间（毫秒级时间戳）
        public Task(Runnable command,long time) {
            this.command = command;
            this.time = System.currentTimeMillis() + time;
        }

        public void run() {
            command.run();
        }

        @Override
        public int compareTo(Task o) {
            return (int)(o.time - this.time);
        }
    }

    static class Timer {
        // 使用这个带优先级版本的阻塞队列来组织这些任务
        private PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
        // 使用这个 locker 对象来解决忙等问题
        private Object locker = new Object();

        public void schedule(Runnable command,long delay) {
            Task task = new Task(command,delay);
            queue.put(task);

            // 每次插入新的任务都要唤醒扫描线程，让扫描线程能够重新计算 wait 的时间，保证新的任务也不会错过
            synchronized (locker) {
                locker.notify();
            }
        }

        public Timer() {
            // 创建一个扫描线程，这个扫描线程就来判定当前的任务，看看是不是已经到时间能执行了
            Thread t = new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Task task = queue.take();
                            long curTime = System.currentTimeMillis();
                            if (task.time > curTime) {
                                // 时间还没到，暂时不执行
                                // 前面的 take 操作会把队首元素给删除掉
                                // 但是此时队首元素的任务还没有执行呢，需要重新插回队列
                                queue.put(task);
                                // 根据时间差，来进行一个等待
                                synchronized (locker) {
                                    locker.wait(task.time - curTime);
                                }
                            } else {
                                // 时间到了
                                task.run();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            // 如果出现了interrupt方法，就能够退出线程
                            break;
                        }
                    }
                }
            };
            t.start();
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 3000);
        System.out.println("main");
    }
}

