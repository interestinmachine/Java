package lambdaDemo;

//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}

//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}

//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}

//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}

//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}

//有返回值多个参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}

public class Test {
    public static void main(String[] args) {
        NoParameterNoReturn noParameterNoReturn = () -> {
            System.out.println("无参数无返回值");
        };
        noParameterNoReturn.test();
    }
}

