class Person {
    // 实例成员变量：对象里面
    // 实例成员没有初始化，默认值为对应的0值，即引用类默认为null，简单类型默认为0
    // char -> '\u0000'  boolean -> false
    public String name;
    // 可以初始化数据成员变量
    public int age = 18;

    // 静态成员变量 不属于对象，属于类和实例成员变量
    // 存放在方法区中
    public static int size; // 只有一份

    // 方法->行为 实例成员方法
    public void fun1() {
        int a = 10; // 局部变量，存储在栈中
        fun2(); // 非静态方法 可以 调用静态方法
        System.out.println("这是非静态的方法");
    }

    // 静态成员方法
    public static void fun2() {
        // age = 99; error 静态方法内部 不能 访问非静态的数据成员
        size = 1000;
        // func1(); 静态方法 不能 调用非静态方法
        System.out.println("这是静态的方法");
    }
}

public class Demo {
    public static void main(String[] args) {
        // 如何访问静态的类方法：类名.方法名()
        Person.fun2();

        // 注意此main是静态的，就像上述所说，静态方法不能调用非静态方法
        // 非要调用只能像这样:通过引用来调用
        Person per2 = new Person();
        per2.fun1();
    }
}

