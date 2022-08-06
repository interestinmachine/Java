package 优先级队列;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {5,3,2,4,7,8,1};
        testHeap.createHeap(array);
        testHeap.heapSort();

    }
}

