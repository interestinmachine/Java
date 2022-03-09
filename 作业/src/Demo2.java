public class Demo2 {
    public static void main(String[] args) {
        //水仙花数
        for (int i = 100; i < 1000; ++i) {
            int tmp = i;
            int sum = 0;
            while (tmp != 0) {
                sum += Math.pow(tmp%10,3);
                tmp /= 10;
            }
            if (sum == i) {
                System.out.println(i + " 为水仙花数！");
            }
        }
    }
}

