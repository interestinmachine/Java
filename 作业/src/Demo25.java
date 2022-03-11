public class Demo25 {
    public static void main(String[] args) {
        // 实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
        int[] arr = new int[]{1,2,3,4,5,6};
        System.out.println(avg(arr));
    }

    public static double avg(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
        }

        return (sum * 1.0 ) / arr.length;
    }
}

