import java.util.Scanner;

public class Demo7 {
    public static void main(String[] args) {
        // 模拟登录：密码问题
        int count = 3;
        Scanner scan = new Scanner(System.in);

        while (count != 0) {
            String num = scan.nextLine();
            if (num.equals("99999")) {
                System.out.println("登录成功！");
                break;
            } else {
                System.out.println("密码错误，请重新输入密码：");
            }
            count--;
        }
        if (count == 0) {
            System.out.println("退出程序");
        }
    }
}

