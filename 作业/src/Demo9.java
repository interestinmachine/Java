import java.util.Scanner;

public class Demo9 {
    public static void main(String[] args) {
        // 输出n*n的乘法口诀表
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(i + "*" + j + " = " +  i * j + "  ");
            }
            System.out.println();
        }
    }
}

