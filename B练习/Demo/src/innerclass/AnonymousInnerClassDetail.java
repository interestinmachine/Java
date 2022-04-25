package innerclass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
    }
}

class Outer05 {
    private int n1 = 99;
    public void f1() {
        //创建一个基于类的匿名内部类
        Person p = new Person() {
            private int n1 = 200;
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了 hi方法 n1 = " + n1);
                System.out.println("外部类的 n1 = " + Outer05.this.n1);
            }
        };
        p.hi(); // 动态绑定，运行类型 Outer05$1

        // 也可以直接调用，匿名内部类本身也是返回对象
        // class 匿名内部类 extends Person {}
//        new Person() {
//            @Override
//            public void hi() {
//                System.out.println("匿名内部类重写了 hi方法，哈哈哈....");
//            }
//        }.hi();
    }
}

class Person { // 类
    public void hi() {
        System.out.println("Person hi()");
    }
}

//抽象类/接口
