/**
 * 抽象类：
 * 1.抽象方法：一个方法如果被abstract修饰，那么这个方法就是 抽象方法
 * 抽象方法可以没有具体的实现
 * 2.包含抽象方法的类，称为抽象类，必须声明成abstract
 *
 * 注意：
 * 1、抽象类不可以被实例化，不能 Shape shape = new Shape();
 * 2、类内的数据成员，和普通类没有区别
 * 3、抽象类主要就是用来被继承的
 * 4、如果一个类继承了这个抽象类，这个类必须重写抽象类中的方法
 * 5、当抽象类A 继承 抽象类B，那么A可以不重写B中的方法，但是一旦A要是再被继承，
 * 那么一定还要重写这个抽象方法。
 * 6、抽象类或者抽象方法 一定是不能被 final 修饰的。
 */

abstract class Shape {
    public abstract void draw();
}

abstract class Triangle extends Shape {

}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个○");
    }
}

class React extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个矩形");
    }
}

public class Demo1 {
    public static void main(String[] args) {
        //抽象类不可以被实例化
        //Shape shape = new Shape();
    }
}

