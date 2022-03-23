public class Test3 {
    public static void main(String[] args) {
        //计算1/1 - 1/2 + 1/3 - 1/4 + 1/5 ....+1/99 - 1/100的值
        int flag = 1;
        double sum = 0;
        for (int i = 1; i <= 100; ++i) {
            if (i % 2 == 0) { //偶数
                sum += (1.0 / i)*(-flag);
            } else { //奇数
                sum += 1.0 / i;
            }
        }
        System.out.println(sum);
    }
}
