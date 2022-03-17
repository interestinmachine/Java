package Demo3;

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

// Bird.java
class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    public void eat(String food) {
        System.out.println("我是一只小鸟");
        System.out.println(this.name + "正在吃" + food);
    }

    public void fly(){
        System.out.println("我是一只小鸟，正在飞");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        // 使用 super 调用父类的构造方法.
        super(name);
        System.out.println("Cat(String)");
    }
}

public class TestDemo1 {
    public static void main(String[] args) {
        Animal animal = new Cat("八哥");
        // A instanceof B 判断A 是不是 B的一个实例
        if (animal instanceof Bird) {
            //向下转型
            Bird bird = (Bird)animal;
            bird.fly();
        } else {
            System.out.println("sadadsadsas");
        }

        // 向下转型不安全
//        Bird bird = (Bird)animal;
//        bird.fly();
    }
}

