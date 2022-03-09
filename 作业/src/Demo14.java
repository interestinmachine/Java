import java.util.Arrays;

public class Demo14 {
    public static void main(String[] args) {
        // 调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < arr.length-1; ++i) {
            for (int j = 0; j < arr.length-1-i; ++j) {
                if (arr[j] % 2 == 0) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

