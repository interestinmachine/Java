package TestInterFace;

class Animal {
    protected String name;
    public Animal(String name){
        this.name = name;
    }
}

interface IFlying {
    void fly();
}

interface IRunning {
    void run();
}

interface ISwimming {
    void swim();
}

//1、一个类可以继承一个普通类/抽象类，并且可以同时实现多个接口
class Cat extends Animal implements IRunning {
    public Cat(String name){
        super(name);
    }
    @Override
    public void run(){
        System.out.println(this.name + "正在用四条腿跑路");
    }
}

class Fish extends Animal implements ISwimming {
    public Fish(String name){
        super(name);
    }
    @Override
    public void swim(){
        System.out.println(this.name + "正在用尾巴游泳");
    }
}

class Frog extends Animal implements IRunning,ISwimming {
    public Frog(String name){
        super(name);
    }
    @Override
    public void run(){
        System.out.println(this.name + "正在跑路");
    }
    @Override
    public void swim(){
        System.out.println(this.name + "正在游泳");
    }
}

public class TestMoreExtends {
    public static void walk(IRunning iRunning){
        System.out.println("追着跑");
    }

    public static void main(String[] args) {
        IRunning iRunning = new Frog("青青");
        walk(iRunning);
    }
}

