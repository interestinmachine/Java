package annotation;

public class Override {
}

class Father {
    public void fly() {
        System.out.println("father 正在飞");
    }
}

class Son extends Father {

    //1. @Override 注解放在 fly 方法上，表示子类 fly 方法重写了父类的 fly
    //2. 这里如果没有写 @Override 还是重写了父类fly
    //3. 如果写了@Override注解，编译器就会去检查该方法是否真的重写了父类的方法，
    //    如果的确重写了，则编译通过，如果没有构成重写，则编译错误。
    //4. 看看@Override的定义
    // 解读：如果发现 @interface ，则表示一个 注解类
    /*
        @Target(ElementType.METHOD)
        @Retention(RetentionPolicy.SOURCE)
        public @interface Override {
        }
     */
    @java.lang.Override
    public void fly() {
        System.out.println("son 正在飞");
    }
}
