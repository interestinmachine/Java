public class Test {
    public static void main(String[] args) {
        B b = new B();
    }
}

class A {
    A() {
        System.out.println("a");
    }

    A(String name){
        System.out.println("a name");
    }
}

class B extends A {
    B(){
        this("abc");
        System.out.println("b");
    }

    B(String name){
        // 默认有个super
        System.out.println("b name");
    }
}

