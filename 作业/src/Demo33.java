import java.util.Arrays;

public class Demo33 {
    public static void main(String[] args) {
        // 实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组.
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = copyOf(arr1);
        System.out.println(Arrays.toString(arr2));

    }

    public static int[] copyOf(int[] arr) {
        int tmp[] = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            tmp[i] = arr[i];
        }
        return tmp;
    }
}

