package innerclass;

import com.sun.org.apache.bcel.internal.generic.I2B;

/**
 * 演示局部内部类的使用
 */
public class LocalInnerClass {
    public static void main(String[] args) {

    }
}

class Outer02{
    private int n1 = 100;
    private void m2(){} // 私有方法
    private void m1(){
        // 1. 局部内部类是定义在外部类的局部位置，通常在方法中
        // 3. 不能添加访问修饰符，。但是可以使用 final 修饰
        // 4. 作用域：仅仅在定义它的方法或代码块中。
        final class Inner02{
            // 2. 可以直接访问外部类的所有成员，包含私有的。
            private int n1 = 200;
            public void f1(){
                // 5. 局部内部类可以直接访问外部类的成员，比如 n1,m2()
                // 7. 如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，
                //    则可以使用（外部类名.this.成员）去访问
                System.out.println("n1 = " + n1 + " 外部类n1 = " + Outer02.this.n1);
                m2();
            }
        }
        // 6. 外部类在方法中，可以创建 Inner02 对象，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}

