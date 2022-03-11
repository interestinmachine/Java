import java.util.Scanner;

public class Demo24 {
    public static void main(String[] args) {
        // 递归求 N 的阶乘
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int sum = 1;
        for (int i = 1; i <= n; ++i) {
            sum *= i;
        }
        return sum;
    }
}

