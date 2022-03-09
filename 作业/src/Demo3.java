public class Demo3 {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 1; i <=100; ++i) {
            int flag = 1;
            if (i % 2 == 0) {
                flag = -1;
                sum += 1.0 / i * flag;
            } else {
                sum += 1.0 / i * flag;
            }
        }
        System.out.println(sum);
    }
}

