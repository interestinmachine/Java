public class Demo19 {
    public static void main(String[] args) {
        // 递归求解汉诺塔问题
        hanio(3,'A','B','C');
    }

    public static void move(char pos1, char pos2) {

        System.out.print(pos1 + "->" + pos2 + " ");
    }

    public static void hanio(int n, char pos1, char pos2, char pos3) {
        if (n == 1) {
            move(pos1,pos3);
        } else {
            hanio(n - 1, pos1, pos3, pos2);
            move(pos1, pos3);
            hanio(n - 1, pos2, pos1, pos3);
        }
    }
}

