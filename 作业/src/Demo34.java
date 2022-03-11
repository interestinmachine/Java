public class Demo34 {
    public static void main(String[] args) {
        // 实现一个方法 toString, 把一个整型数组转换成字符串.
        // 例如数组 {1, 2, 3} , 返回的字符串为 "[1, 2, 3]", 注意 逗号 的位置和数量.
        int[] arr = new int[]{1,2,3};
        System.out.println(toString(arr));
    }

    public static String toString(int[] arr) {
        String tmp = "[" + arr[0];
        for (int i = 1; i < arr.length; ++i) {
            tmp += ", " + arr[i];
        }
        tmp += "]";
        return tmp;
    }
}

