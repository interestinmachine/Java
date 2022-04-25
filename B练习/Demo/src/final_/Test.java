package final_;

public class Test {
    public static void main(String[] args) {
        System.out.println(A.num);
    }
}

class A{
    public final static int num = 100;

    static {
        System.out.println("类被加载了");
    }
}

