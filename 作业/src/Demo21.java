import java.util.Scanner;

public class Demo21 {
    public static void main(String[] args) {
        // 写一个递归方法，输入一个非负整数，返回组成它的数字之和
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            System.out.println(sum(n));
        }
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }

        return n%10 + sum(n/10);
    }
}

