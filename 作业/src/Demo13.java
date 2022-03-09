import java.util.Scanner;

public class Demo13 {
    public static void main(String[] args) {
        // 求 N 的阶乘 。
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = 1;
        for (int i = 1; i <= n; ++i) {
            sum *= i;
        }
        System.out.println(sum);
    }
}

