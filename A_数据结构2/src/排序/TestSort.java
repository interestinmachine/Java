package 排序;


import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class TestSort {

    /**
     * 直接插入排序
     * 时间复杂度：最坏情况（逆序）：O(n²)
     * 最好情况（有序）：O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * 使用场景：当数据量小，并且已经趋于有序的时候。
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[gap + j] = tmp; // 因为内层循环里有 j -= gap，所以要 gap+j 回退回来
        }
    }

    /**
     * 希尔排序
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param array
     */
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 1) {
            shell(array, gap);
            gap /= 2;
        }
        shell(array, 1);
    }

    /**
     * 选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    private static void shiftDown(int[] array, int parent, int len) {
        int child = (2 * parent) + 1;
        while (child < len) {
            if (child + 1 < len && array[child] < array[child + 1]) {
                child++;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    public static void createSort(int[] array) {
        for (int p = (array.length - 1 - 1) / 2; p >= 0; p--) {
            shiftDown(array, p, array.length);
        }
    }

    /**
     * 堆排序,默认大根堆
     * 时间复杂度：O(n*log2n)
     * 空间复杂度：O(n)
     * 稳定性：不稳定
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        createSort(array);
        int end = array.length - 1;
        while (end >= 0) {
            swap(array, end, 0);
            shiftDown(array, 0, end);
            --end;
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度:O(n^2)
     * 空间复杂度：O(1)
     * 此处为优化后的代码
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
    }

    // Hoare版本快速排序
    private static int partitionHoare(int[] array, int low, int high) {
        int i = low;
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                --high;
            }
            while (low < high && array[low] <= tmp) {
                ++low;
            }
            swap(array, low, high);
        }
        swap(array, low, i);
        return low;
    }

    // 挖坑版本快速排序
    private static int partitionHole(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                --high;
            }
            array[low] = array[high];
            while (low < high && array[low] <= tmp) {
                ++low;
            }
            array[high] = array[low];
        }
        array[low] = tmp;
        return low;
    }

    // 双指针法
    private static int partition(int[] array, int left, int right) {
        int d = left + 1;
        int tmp = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < tmp) {
                swap(array, i, d);
                d++;
            }
        }
        swap(array, d - 1, left);
        return d - 1;
    }

    // 改进快排算法，在函数 quick 里调用
    public static void insertSortRange(int[] array, int begin, int end) {
        for (int i = begin + 1; i <= end; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    private static int medianOfThreeIndex(int[] array, int left, int right) {
        int mid = left + (right - left) >>> 1;
        if (array[left] < array[right]) {
            if (array[mid] < array[left]) {
                return left;
            } else if (array[mid] > array[right]) {
                return right;
            } else {
                return mid;
            }
        } else {
            if (array[mid] < array[right]) {
                return right;
            } else if (array[mid] > array[left]) {
                return left;
            } else {
                return mid;
            }
        }
    }

    private static void quick(int[] array, int left, int right) {
        if (left >= right) return;

        // 1. 在某个区间的时候，使用直接插入排序（优化过的）
        if (right - left + 1 <= 100) {
            //使用直接插入排序（修改版）
            insertSortRange(array, left, right);
            return;
        }

        //2. 三数取中法（优化的是本身的分割，从而减少递归的深度）
        int index = medianOfThreeIndex(array, left, right);
        swap(array, index, left);

        //TODO:3. 将基准相同的数字 靠到一起，从而减少递归的区间

        // int pivot = partitionHoare(array,left,right);
        // int pivot = partitionHole(array,left,right);
        int pivot = partition(array, left, right);
        quick(array, left, pivot - 1);
        quick(array, pivot + 1, right);
    }

    /**
     * 快速排序 (Hoare法)
     * 时间复杂度：O(n*log2n) (最佳：每次对半分）
     * O(n^2) (最差：数据有序或逆序）
     * 空间复杂度：O(log2n) (最好）
     * O(n) (最差）
     * 稳定性：不稳定
     *
     * @param array
     */
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    /**
     * 非递归实现快速排序
     *
     * @param array
     */
    public static void quickSortNor(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int left = 0;
        int right = array.length - 1;
        int pivot = partitionHole(array, left, right);
        //pivot左边有2个及以上的数据
        if (pivot > left + 1) {
            stack.push(left);
            stack.push(pivot - 1);
        }
        if (pivot < right - 1) {
            stack.push(pivot + 1);
            stack.push(right);
        }
        while (!stack.empty()) {
            right = stack.pop();
            left = stack.pop();

            pivot = partitionHole(array, left, right);
            //pivot左边有2个及以上的数据
            if (pivot > left + 1) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if (pivot < right - 1) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = high;
        int[] tmpArr = new int[high - low + 1];
        int k = 0; //tmpArr的下标
        while (s1 <= e1 && s2 <= e2) {
            if (array[s1] <= array[s2]) {
                tmpArr[k++] = array[s1++];
            } else {
                tmpArr[k++] = array[s2++];
            }
        }

        while (s1 <= e1) {
            tmpArr[k++] = array[s1++];
        }
        while (s2 <= e2) {
            tmpArr[k++] = array[s2++];
        }

        for (int i = 0; i < tmpArr.length; i++) {
            array[low + i] = tmpArr[i];
        }
    }

    private static void mergeSortInternal(int[] array, int low, int high) {
        if (low >= high) return;

        int mid = low + ((high - low) >>> 1);
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid + 1, high);

        merge(array, low, mid, high);
    }

    /**
     * 归并排序
     * 时间复杂度：O(n*log2n)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     *
     * @param array
     */
    public static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length - 1);
    }

    /**
     * 非递归实现归并排序
     *
     * @param array
     */
    public static void mergeSortNor(int[] array) {
        int gap = 1;
        while (gap < array.length) {
            for (int i = 0; i < array.length; i += 2 * gap) {
                int left = i;
                int mid = left + gap - 1;
                //修正 mid
                if (mid >= array.length) {
                    mid = array.length-1;
                }
                int right = mid + gap;
                // 修正 right
                if (right >= array.length) {
                    right = array.length-1;
                }

                merge(array, left, mid, right);
            }
            gap *= 2;
        }
    }

    /**
     * 计数排序
     * 时间复杂度：O(范围 + n)
     * 空间复杂度：O(范围)
     * @param array
     */
    public static void countSort(int[] array) {
        //1.获取最大值和最小值
        int minVal = array[0];
        int maxVal = array[0];
        // O(n)
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minVal) {
                minVal = array[i];
            }
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        //2.开始计数
        int range = maxVal-minVal+1;
        int[] count = new int[range];
        // O(n)
        for (int i = 0; i < array.length; i++) {
            count[array[i]-minVal]++;
        }

        //3.遍历计数数组，把数据放回array
        int index = 0;
        // O(范围 + n)
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                array[index++] = i+minVal;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 4, 1, 9, 10, 8, 2, 3, 8};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main1(String[] args) {
        int[] array = new int[1_0000_000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1_0000_0000);
        }
        long startTime = System.currentTimeMillis();
        quickSortNor(array);
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - startTime));
    }

    public static void swap(int[] array, int i, int s) {
        int tmp = array[i];
        array[i] = array[s];
        array[s] = tmp;
    }
}

