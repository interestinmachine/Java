import javax.script.ScriptContext;
import java.util.Scanner;

public class Demo15 {
    public static void main(String[] args) {
        /**
         * 创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
         *
         * 要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
         */
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int n3 = scan.nextInt();
        System.out.println(maxNum3(n1,n2,n3));

    }
    public static int maxNum2(int n1, int n2) {
        return Math.max(n1, n2);
    }

    public static int maxNum3(int n1, int n2, int n3) {
        return maxNum2(maxNum2(n1,n2),n3);
    }
}

