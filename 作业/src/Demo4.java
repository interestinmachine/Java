import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        // 求两个正整数的最大公约数

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            int tmp = num2;
            while (num1 % num2!=0) {
                tmp = num1 % num2;
                num1 = num2;
                num2 = tmp;
            }
            System.out.println(tmp);
        }

    }
}

