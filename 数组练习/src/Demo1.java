import java.util.Arrays;

public class Demo1 {

    // 数组转字符串
    public static void main1(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        String newArr = Arrays.toString(arr);
        System.out.println(newArr);
    }

    // 数组拷贝
    public static void main2(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        // newArr和arr引用的是同一个数组
        int[] newArr = arr;
        newArr[0] = 100;
        System.out.println("newArr: " + Arrays.toString(arr));

        // 使用Arrays中copyOf方法完成数组的拷贝
        // copyOf方法在进行数组拷贝时，创建了一个新数组
        arr[0] = 1;
        // arr和newArr引用的不是同一个数组
        newArr = Arrays.copyOf(arr,arr.length);
        System.out.println("newArr: " + Arrays.toString(newArr));

        // 修改arr引用的内容时，对newArr没有影响
        arr[0] = 90;
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("newArr: " + Arrays.toString(newArr));

        // 拷贝某个范围
        int[] newArr2 = Arrays.copyOfRange(arr,2,4);
        System.out.println("newArr2: " + Arrays.toString(newArr2));
    }

    // 实现自己版本的拷贝数组
    public static int[] myCopyOf(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            ret[i] = arr[i];
        }
        return ret;
    }

    // 求数组中元素的平均值
    public static void main3(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(avg(arr));
    }

    public static double avg(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return (double) sum / (double) arr.length;
    }
}

