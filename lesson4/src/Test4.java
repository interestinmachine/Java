public class Test4 {
    public static void main(String[] args) {
        //求类似于水仙花数（三次幂），此处求的是1~6次幂的数（具体可百度）
        for (int n = 1; n < 999999; ++n) {
            int count = 0;
            int tmp = n;
            while (tmp != 0) {
                count++;
                tmp /= 10;
            }
            tmp = n;
            int sum = 0;
            while (tmp != 0) {
                sum += Math.pow(tmp%10,count);
                tmp /= 10;
            }
            if (sum == n) {
                System.out.println(sum + " is my result!");
            }
        }
    }
}
