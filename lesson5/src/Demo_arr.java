import java.util.Arrays;
public class Demo_arr {
    public static void main(String[] args) {
        // 数组的三种遍历
        int[] arr = new int[]{1,2,3,4,5,6,7};

        // 第一种遍历
        for(int i = 0; i < arr.length;++i) {
            System.out.print(arr[i] + " ");
        }

        // 第二种遍历:for-each遍历
        for (int e : arr) {
            System.out.print(e + " ");
        }

        // 第三种遍历
        System.out.println(Arrays.toString(arr));//将数组以字符串的形式进行输出

        int[] array = null;
        System.out.println(array[0]);
    }




}

