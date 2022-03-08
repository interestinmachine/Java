import javax.print.attribute.standard.PresentationDirection;
import java.util.Arrays;

public class Demo2 {

    // 查找数组中指定元素（顺序查找）
    public static int find(int[] arr, int data) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public static void main1(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(find(arr,3));
        System.out.println(find(arr,0));
    }

    // 二分查找
    public static int binarySearch(int[] arr, int data) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = left + (right >> 1);
            if (arr[mid] > data) { //到左半区间找
                right = mid - 1;
            } else if (arr[mid] < data) { // 到右半区间找
                left = mid + 1;
            } else {
                return mid; //找到了
            }
        }
        return -1; //代表没找到
    }

    public static void main2(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(binarySearch(arr,6));
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            // 每一趟排序后，最大值都会跑到数组的最末端
            for (int j = 1; j < arr.length - i; ++j) {
                if (arr[j-1] > arr[j]) {
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main3(String[] args) {
        /*int[] arr = {9,5,2,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));*/

        //java中更高效的排序算法
        int[] arr = {9,5,2,7};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 数组逆序
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            ++left;
            --right;
        }
    }

    public static void main4(String[] args) {
        int[] arr = {1,2,3,4,5};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 二维数组
    public static void main5(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        // 打印二维数组的方法
        System.out.println(Arrays.deepToString(arr));

        for (int row = 0; row < arr.length; ++row) {
            for (int col = 0; col < arr[row].length; ++col) {
                System.out.print(arr[row][col] + "\t");
            }
            System.out.println();
        }
    }

    // 不规则的二维数组
    public static void main(String[] args) {
        int[][] array = new int[2][];
        // 注意：C语言 是可以指定列，行可以自动推导
        // Java中，行必须指定，列不可以自动推导
        array[0] = new int[3]; // 第一行有三列
        // 也可以进行初始化：array[0] = new int[]{1,2,3};
        array[1] = new int[2]; // 第二行有两列
    }
}

