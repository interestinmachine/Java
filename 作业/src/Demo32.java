import java.util.Scanner;

public class Demo32 {
    public static void main(String[] args) {
        // 给定一个有序整型数组, 实现二分查找
        int[] arr = new int[]{1,4,6,8,10,14,17,20};
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        System.out.println(binarySearch(arr,target));
    }

    public static int binarySearch(int[] srcArray, int des) {
        //定义初始最小、最大索引
        int low = 0;
        int high = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (low <= high) {
            //计算出中间索引值
            int middle = (high + low) >>> 1;//防止溢出
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                //判断上限
            } else {
                low = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }
}

