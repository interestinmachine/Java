public class Demo3 {
    // 汉诺塔的移动
    public static void move(char pos1, char pos2) {

        System.out.println(pos1 + "->" + pos2);
    }

    /**
     *
     * @param n     盘子的个数
     * @param pos1  当前位置
     * @param pos2  中途位置
     * @param pos3  最终位置
     */
    public static void hanio(int n, char pos1, char pos2, char pos3) {
        if (n == 1) {
            move(pos1,pos3);
        } else {
            hanio(n-1,pos1,pos3,pos2);
            move(pos1,pos3);
            hanio(n-1,pos2,pos1,pos3);
        }
    }
    public static void main(String[] args) {
        hanio(3,'A','B','C');
    }
}

