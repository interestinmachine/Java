import java.util.Scanner;

/**
 * 方法：功能
 * 语法：public static 返回值类型 方法名(形参列表) {
 *     方法体；
 * }
 *
 *  方法名：要采用小驼峰的形式。maxNum
 *
 *  public static:因为当前所有的方法 写完之后 会在main方法中调用
 *  因为main方法是public static的。
 */

public class Demo {

    public static int maxNum(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

    // 求3个数的最大值
    public static int maxNumOf3(int num1, int num2, int num3) {
         return maxNum(maxNum(num1,num2),num3);
    }

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        System.out.println(maxNum(n1,n2));*/

        int num1 = 10;
        int num2 = 30;
        int num3 = -1;
        System.out.println(maxNumOf3(num1,num2,num3));
    }
}
