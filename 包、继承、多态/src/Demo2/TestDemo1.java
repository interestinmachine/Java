package Demo2;

class Animal {
    public String name;
    public Animal(String name) {
        this.name = name;
        System.out.println("Animal(String)");
    }
    public void eat(String food) {
        System.out.println(this.name + "正在吃" + food);
    }
}

class Cat extends Animal {
    public int count = 99;
    public Cat(String name) {
        // 使用 super 调用父类的构造方法.
        super(name);
        System.out.println("Cat(String)");
    }
}

public class TestDemo1 {

    // 发生向上转型的时机：

    //1.赋值
    public static void main1(String[] args) {
        //向上转型-》 父类引用 引用子类对象
        Animal animal = new Cat("咪咪");
        animal.eat("noodles");

        //animal.count; error 向上转型后，通过父类的引用 只能访问父类自己的方法或属性
        //父类引用 只能访问自己特有的
    }

    //2.传参
    public static void func(Animal animal){
        animal.eat("food");
    }

    public static void main2(String[] args) {
        Cat cat = new Cat("咪咪");
        func(cat);
    }

    //3.返回值
    public static Animal func2() {
//        Cat cat = new Cat("咪咪");
//        return cat;
        return new Cat("咪咪");
    }

    public static void main(String[] args) {
        Animal animal = func2();
        animal.eat("nut");

    }
}

