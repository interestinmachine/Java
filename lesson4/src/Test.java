import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int age = scan.nextInt();
            if (age <= 18) {
                System.out.println("少年");
            } else if (age <= 55) {
                System.out.println("中年");
            } else {
                System.out.println("老年");
            }
        }
    }
}
