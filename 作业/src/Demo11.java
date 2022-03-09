import java.util.Scanner;
public class Demo11 {
    public static void main(String[] args) {
        // 求斐波那契数列的第n项。(迭代实现)
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int b = Fibonacci(n);
        System.out.println(b);

    }
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}

