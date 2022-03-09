import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        // 求一个整数在内存当中存储时，二进制1的个数
        int count = 0;
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        while (number != 0) {
            if ((number & 1) == 1) {
                ++count;
            }
            number >>= 1;
        }
        System.out.println(count);
    }
}

