public class Demo17 {
    public static void main(String[] args) {
        // 在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
        System.out.println(Sum(4,5));
        System.out.println(Sum(3.1,2.8,1.9));
    }

    public static int Sum(int num1, int num2) {
        return num1+num2;
    }

    public static double Sum(double d1,double d2,double d3) {
        return d1+d2+d3;
    }
}

