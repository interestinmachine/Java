import java.util.Scanner;

public class Demo20 {
    public static void main(String[] args) {
        // 递归求斐波那契数列的第 N 项
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(Fibonacci(n));
    }

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}

