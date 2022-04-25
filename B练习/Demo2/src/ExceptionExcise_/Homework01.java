package ExceptionExcise_;

public class Homework01 {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            System.out.println(cal(num1,num2));
        } catch (NumberFormatException e) {
            System.out.println("请输入整数");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("请输入两个整数");
        } catch (ArithmeticException e){
            System.out.println("除数不能为0");
        }

    }

    public static double cal(int n1,int n2){
        double arg = 1.0 *n1 / n2;
        return arg;

    }
}

