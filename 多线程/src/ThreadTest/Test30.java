package ThreadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test30 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        // 由于 Thread 不能直接传一个 callable 实例
        // 就需要一个辅助的类来包装下
        // futureTask 保存 callable 返回的结果
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();

        // 尝试在 main 线程中获取结果
        // 如果 FutureTask 中的结果还没有生成，此时就会阻塞等待。
        // 一直等到最终线程把结果计算出来之后，get 才会返回
        Integer result = futureTask.get();
        System.out.println(result);
    }
}

