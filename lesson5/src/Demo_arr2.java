import java.util.Arrays;

public class Demo_arr2 {
    public static void main(String[] args) {
        /*int[] arr = {1,2,3};
        func(arr);
        System.out.println("arr[0] = " + arr[0]);*/
        int[] array = {1,2,3,4,5,6};
        int[] ret = func2(array);
        System.out.println(Arrays.toString(ret));

    }

    public static void func(int[] a) {
        a[0] = 10;
        System.out.println("a[0] = " + a[0]);
    }

    //将数组a里面的元素扩大两倍，并返回，不改变原有的数组
    public static int[] func2(int[] a) {
        int[] tmp = new int[a.length];
        for (int i = 0;i < a.length; ++i) {
            tmp[i] = a[i] * 2;
        }
        return tmp;
    }
}

