public class Homework05 {
    public static void main(String[] args) {
        A a = new A();
        a.f1();
    }
}

class A {
    public final String NAME = "bbb";
    public void f1(){
        class B {
            private final String NAME = "aaa";
            public void show(){
                System.out.println(NAME);
                System.out.println(A.this.NAME);
            }
        }

        B b = new B();
        b.show();
    }
}

