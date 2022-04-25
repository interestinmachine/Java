import java.math.BigInteger;

public class BigInteger01 {
    public static void main(String[] args) {
        //当我们编程中，需要处理很大的整数 long 不够用
        //可以使用 BigInteger 的类来搞定
//        long l = 2357685999999999999999999;
//        System.out.println(l);

        BigInteger bigInteger = new BigInteger("2357685999999999999999999");
        BigInteger bigInteger1 = new BigInteger("100");
        System.out.println(bigInteger);

        //1. 在堆 BigInteger 进行加减乘除的时候，需要使用对应的方法，不能直接进行 + - * /
        //2. 可以创建一个 要操作的 BigInteger 然后进行相应的操作
        BigInteger add = bigInteger.add(bigInteger1);
        System.out.println(add); // 加法

        BigInteger subtract = bigInteger.subtract(bigInteger1);
        System.out.println(subtract); //减法

        BigInteger multiply = bigInteger.multiply(bigInteger1);
        System.out.println(multiply); // 乘法

        BigInteger divide = bigInteger.divide(bigInteger1);
        System.out.println(divide); // 除法
    }
}

