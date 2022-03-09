import java.util.Scanner;
import java.util.Random;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(20);

        while (scan.hasNextInt()) {
            int num = scan.nextInt();
            if (num > number) {
                System.out.println("大于");
            } else if (num < number) {
                System.out.println("小于");
            } else {
                System.out.println("等于！");
                break;
            }
        }


    }
}

