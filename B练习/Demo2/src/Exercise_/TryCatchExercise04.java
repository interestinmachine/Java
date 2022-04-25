package Exercise_;

import java.util.Scanner;

public class TryCatchExercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String inputStr = "";
        while (true) {
            System.out.println("请输入一个整数：");
            inputStr = scanner.next();
            try {
                num = Integer.parseInt(inputStr);
                break;
            } catch (NumberFormatException e){
                System.out.println("你输入的数不是整数");
            }

        }
    }
}

