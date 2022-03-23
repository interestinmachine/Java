import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        //计算一个二进制数中1的个数（优化版本）
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            System.out.println(count);
        }

    }
}
