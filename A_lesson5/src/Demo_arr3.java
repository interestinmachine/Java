public class Demo_arr3 {
    // 模拟实现个Arrays类中的方法toString()
    public static String myToString(int[] array) {
        String tmp = "[" + array[0];

        for(int i = 1;i < array.length; ++i) {
            tmp += ", " + array[i];
        }
        tmp += "]";
        return tmp;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(myToString(arr));
    }
}

