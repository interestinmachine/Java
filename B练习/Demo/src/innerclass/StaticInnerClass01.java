package innerclass;

public class StaticInnerClass01 {
    public static void main(String[] args) {
        //外部其他类，使用静态内部类
        Outer10 outer10 = new Outer10();
        //方式1：
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();

        //方式2：
        //调用的普通方法
        Outer10.Inner10 inner101 = outer10.getInner10();
        inner101.say();
        //调用的静态方法
        Outer10.Inner10 inner102 = Outer10.getInner10_();
        inner102.say();

    }
}

class Outer10{
    private static String name = "张三";
    static class Inner10 {
        public void say() {
            System.out.println(name);
        }
    }

    public void m1() { // 外部类---访问--->静态内部类，方法方式：创建对象，再访问
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    public Inner10 getInner10(){
        return new Inner10();
    }

    public static Inner10 getInner10_(){
        return new Inner10();
    }
}

