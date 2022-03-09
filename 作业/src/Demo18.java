public class Demo18 {
    public static void main(String[] args) {
        // 青蛙跳台阶问题

    }

    public static int f(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            return f(n-1) + f(n-2);
        }
    }
}

