package innerclass;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04{ // 外部类
    private int n1 = 10; // 属性
    public void method() { // 方法
        // 基于接口的匿名内部类
        // 1. 需求：想使用 IA 接口，并创建对象
        // 2. 传统方式，是写一个类，实现该接口，并创建对象
        // 3. 我们此次代码的需求是：Tiger/Dog 类只是使用一次，后面不再使用
        // 4. 可以使用匿名内部类来简化开发
        // 5. tiger 的编译类型 ？ IA
        // 6. tiger 的运行类型 ？ 就是匿名内部类 Outer04$1
        /*
            我们看底层 会分配 类名 Outer04$1
            class Outer04$1 implements IA {
                @Override
                public void cry(){
                    System.out.println("老虎叫唤...");
                }
            }
         */
        // 7. jdk底层在创建匿名内部类 Outer04$1，立即马上就创建了 Outer04$1实例，并把地址
        //    返回给 tiger
        // 8. 匿名内部类使用一次，就不能再使用，但是对象可以使用多次
        IA tiger = new IA() {
            @Override
            public void cry(){
                System.out.println("老虎叫唤...");
            }
        };
        System.out.println("tiger的运行类型 = " + tiger.getClass());
        tiger.cry();
    }
}

interface IA{
    public void cry();
}

//class tiger implements IA{
//    @Override
//    public void cry() {
//        System.out.println("老虎叫唤...");
//    }
//}
//
//class Dog implements IA {
//    @Override
//    public void cry() {
//        System.out.println("狗叫唤");
//    }
//}

