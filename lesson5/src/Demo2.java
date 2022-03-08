public class Demo2 {
    // 方法的重载
    public static int maxNum(int a, int b) {
        return a > b ? a : b;
    }

    public static double maxNum(double a, double b) {
        return a > b ? a : b;
    }

    public static int maxNumOf3(int a, int b, int c) {
        return maxNum(maxNum(a,b),c);
    }

    public static double maxNumOf3(double a, double b, double c) {
        return maxNum(maxNum(a,b),c);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 40;
        System.out.println(maxNumOf3(a,b,c));

        double d1 = 2.134;
        double d2 = -1.739;
        double d3 = 9.087;
        System.out.println(maxNumOf3(d1,d2,d3));
    }
}
