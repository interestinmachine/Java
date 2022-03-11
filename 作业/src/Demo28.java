public class Demo28 {
    public static void main(String[] args) {
        // 实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
        int[] arr = new int[]{1,2,3,4,5,6};
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

