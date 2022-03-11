public class Demo31 {
    public static void main(String[] args) {
        // 给定一个整型数组, 判定数组是否有序（递增）
        int[] arr1 = new int[]{1,2,3,4,5,6,9};
        int[] arr2 = new int[]{9,23,0,1,4,2};
        System.out.println(isIncreaseOrder(arr1));
        System.out.println(isIncreaseOrder(arr2));
    }

    public static boolean isIncreaseOrder(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length-1; ++i) {
            if (arr[i] > arr[i+1]) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}

