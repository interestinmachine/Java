class MaxNum {
    public int maxNum(int num1,int num2) {
        return Math.max(num1,num2);
    }

    public double maxNum(double d1,double d2) {
        return Math.max(d1, d2);
    }

    public double maxNum(double d1, double d2, int num1) {
        return Math.max(Math.max(d1,d2),num1);
    }
}

public class Demo16 {
    public static void main(String[] args) {
        /**
         * 在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，
         * 还可以求两个小数的最大值，以及两个小数和一个整数的大小关系
         */

        MaxNum max = new MaxNum();
        System.out.println(max.maxNum(1,2));
        System.out.println(max.maxNum(1.1,2.2));
        System.out.println(max.maxNum(1.1,2.2,3));

    }
}

