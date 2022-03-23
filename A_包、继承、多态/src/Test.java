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
    public Cat(String name) {
        // 使用 super 调用父类的构造方法.
        super(name);
        System.out.println("Cat(String)");
    }
}


public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("aaa");
    }
}