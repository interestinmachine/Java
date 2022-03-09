import java.util.Scanner;

public class Demo12 {
    public static void main(String[] args) {
        // 求1！+2！+3！+4！+........+n!的和
        int sum = 0;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 1; i <= n; ++i) {
            sum += factorial(i);
        }
        System.out.println(sum);
    }

    public static int factorial(int n) {
        int sum = 1;
        for (int i = 1; i <= n; ++i) {
            sum *= i;
        }
        return sum;
    }
}

