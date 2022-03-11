public class Demo26 {
    public static void main(String[] args) {
        // 实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
        int[] arr = new int[]{1,2,3,4,5,6};
        System.out.println(sum(arr));
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
        }
        return sum;
    }
}

