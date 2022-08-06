package ThreadTest;

import java.util.concurrent.atomic.AtomicInteger;

public class Test28 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        // 相当于 i++
        atomicInteger.getAndIncrement();
    }
}

