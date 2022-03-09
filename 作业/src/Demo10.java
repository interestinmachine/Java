public class Demo10 {
    public static void main(String[] args) {
        // 有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
        int res = 0;
        int[] arr = new int[]{1,2,3,2,4,3,1};
        for (int i = 0; i < arr.length; ++i) {
            res ^= arr[i];
        }
        System.out.println(res);
    }
}

