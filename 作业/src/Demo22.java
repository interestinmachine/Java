import java.util.Scanner;

public class Demo22 {
    public static void main(String[] args) {
        // 按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4) （递归）
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        print(n);
    }

    public static void print(int n) {
        if (n == 0) {
            return;
        }

        if (n > 9) {
            print(n/10);
        }
        System.out.print(n%10 + " ");

    }
}

