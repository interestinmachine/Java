class Person2 {
    private String name;
    private int age;
    private static int count;

    public Person2() {
        this("caocao",18); // 只能放在第一行，否则报错
        // this("zhangfei"); 只能调用一个
        System.out.println("Person2<init>");
        // this("caocao",18);不在第一行则报错

        //本地代码块，没啥用
        {
            System.out.println("本地代码块.......");
        }
    }

    // 可以使用alt + insert自动生成
    public Person2(String Name,int Age) {
        this.name = Name;
        this.age = Age;
        System.out.println("Person2<String,int>");
    }

    public Person2(String Name) {

    }

    // 实例代码块，不过没啥用，了解即可
    //
    {
        this.name = "zhangfei ";
        count = 99;
        System.out.println("实例代码块........");
    }

    // 静态代码块
    static {
        // this.name = "zhangsan"; 不能访问非静态的数据成员
        // count = 100;
        System.out.println("静态代码块.......");
    }
}

public class Demo3 {
    public static void main(String[] args) {
        Person2 per = new Person2();
        System.out.println("================");
        Person2 per2 = new Person2();
        // 重要：静态的内容只会被执行一次，且最早被执行的。
    }
}

