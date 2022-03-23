import java.util.Scanner;
public class Test2 {
    public static void main(String[] args) {
        //求两个数的最大公约数
        //使用辗转相除法
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = b;
        while (a % b != 0) {
            c= a % b;
            a = b;
            b = c;
        }
        System.out.println(c);
    }
}
