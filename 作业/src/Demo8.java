import java.util.Scanner;

public class Demo8 {
    public static void main(String[] args) {
        // 输出整数的每一位：如123的每一位是1,2,3，
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int tmp = num;
        print(tmp,num);

    }

    public static void print(int tmp, int n) {
        if (n < 0) {
            System.out.println("-");
            n = -n;
        }

        if (n > 9) {
            print(tmp, n / 10);
        }
        System.out.print(n % 10);
        if (n != tmp) {
            System.out.print(", ");
        }
    }
}

