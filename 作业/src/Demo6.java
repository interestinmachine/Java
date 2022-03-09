import java.util.Scanner;

public class Demo6 {
    public static void main(String[] args) {
        // 获取一个数二进制序列中所有的偶数位和奇数位，分别输出二进制序列
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        System.out.println("奇数位位：");
        for (int i = 31; i >= 1; i -= 2) {
            System.out.print(num>>i&1);
        }
        System.out.println();
        System.out.println("偶数位为：");
        for (int i = 30; i >= 0; i-=2) {
            System.out.print(num>>i&1);
        }
    }
}

