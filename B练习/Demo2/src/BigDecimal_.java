import java.math.BigDecimal;

public class BigDecimal_ {
    public static void main(String[] args) {
        //当我们需要保存一个精度很高的数时，double 不够用
        // 这时可以用 BigDecimal
//        double d = 199.12123213213221321312123213d;
//        System.out.println(d);

        BigDecimal bigDecimal = new BigDecimal("199.12123213213221321312123213");
        System.out.println(bigDecimal);

        BigDecimal bigDecimal1 = new BigDecimal("1.1");
        System.out.println(bigDecimal.add(bigDecimal1));
        System.out.println(bigDecimal.subtract(bigDecimal1));
        System.out.println(bigDecimal.multiply(bigDecimal1));

        //除法这样写可能会报异常：ArithmeticException，会出现无限循环小数
        //System.out.println(bigDecimal.divide(bigDecimal1));

        //在调用 divide 方法时，指定精度即可，BigDecimal.ROUND_CEILING
        //如果有无限循环小数，就会保留 分子 的精度
        System.out.println(bigDecimal.divide(bigDecimal1,BigDecimal.ROUND_CEILING));
    }
}

