package 优先级队列;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap() {
        elem = new int[10];
    }

    /**
     * 建堆的时间复杂度：O(n),过程比较复杂，T(n)=n-log2(n+1)
     * 建立 大根堆
     * @param array
     */
    public void createHeap(int[] array) {
        // 这一步不是必须的。这里只是在准备数据
        for (int i = 0; i < array.length; i++) {
            elem[i] = array[i];
            usedSize++;
        }

        for (int p = (usedSize - 1 - 1) / 2; p >= 0; p--) {
            shiftDown(p, usedSize);
        }
    }

    /**
     * @param parent 为每棵子树的根节点的下标
     * @param len    每棵子树调整结束的结束条件
     *               向下调整的时间复杂度：O(logn)
     */
    public void shiftDown(int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            // 如果有孩子，找到左右孩子的最大值
            if (child + 1 < len && elem[child] < elem[child + 1]) {
                child++;
            }
            // 当前child下标一定保存的是左右孩子最大值的下标
            //接下来，孩子的最大值跟根节点比较大小
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child; // 开始更新下标，继续看下面的子树是否是大根堆
                child = parent * 2 + 1;
            } else {
                break; // 此时说明已经是大根堆了，不需要进行再次调整了
            }
        }
    }

    public void push(int val) {
        if (isFull()) {
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[usedSize] = val;
        shiftUp(usedSize);
        ++usedSize;
    }

    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    // 删除堆顶元素，删完后，仍要保持大根堆
    public void pollHeap() {
        if (isEmpty()) {
            System.out.println("空间里没有元素，无法删除~");
            return;
        }

        int tmp = elem[0];
        elem[0] = elem[usedSize-1];
        elem[usedSize-1] = tmp;
        usedSize--;
        shiftDown(0,usedSize);
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    // 获取堆顶元素
    public int peekHeap() {
        return elem[0];
    }


    /**
     * 求最小的K个数
     * 时间复杂度：O(n*log2(k))，n为遍历的元素个数，k是堆中只有k个元素
     * @param array
     * @param k
     * @return
     */
    public  int[] topK(int[] array,int k) {
        if (k == 0) {
            return new int[k];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.offer(array[i]);
            } else {
                int top = maxHeap.peek();
                if (array[i] < top) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = maxHeap.poll();
        }
        return ret;
    }

    /**
     * 堆排序
     * O(n*log2(n))
     */
    public void heapSort() {
        int end = usedSize-1;
        while (end > 0) {
            int tmp = elem[0];
            elem[0] = elem[end];
            elem[end] = tmp;
            shiftDown(0,end);
            end--;
        }
    }
}




