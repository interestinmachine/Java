public class Demo23 {
    public static void main(String[] args) {
        // 递归求 1 + 2 + 3 + ... + 10
        System.out.println(sum(10));
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n-1);
    }
}

