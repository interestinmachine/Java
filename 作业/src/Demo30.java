import java.util.Arrays;

public class Demo30 {
    public static void main(String[] args) {
        // 给定一个整型数组, 实现冒泡排序(升序排序)
        int[] arr = new int[]{5,6,1,2,9,3,4};
        for(int i = 0; i < arr.length-1; ++i) {
            for (int j = 0; j < arr.length-1-i; ++j) {
                if (arr[j] < arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

