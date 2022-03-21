package TestInterFace;

/**
 * 接口（InterFace）
 * 1、接口当中的方法，都是抽象方法
 * 2、其实可以有具体的实现方法，这个方法是被 default 修饰的（JDK1.8加入的）
 * 3、接口当中定义的成员变量，默认是常量
 * 4、接口当中的成员变量默认是：public static final（不写也可以），成员方法是：public abstract
 * 5、接口是不可以被实例化的
 * 6、接口和类之间的关系：implements
 * 7、为了解决Java单继承的问题，可以实现多个接口
 * 8、只要这个类实现了该接口，那么你就可以进行向上转型了
 */
interface Shape {
    public static final int a = 10;
    //int b = 20;

    public abstract void draw();

//    default public void func() {
//        System.out.println("这是接口类中的方法实现");
//    }
}

class Cycle implements Shape {
    @Override
    public void draw() {
        System.out.println("画一个○");
    }
}

public class TestInterFace {
    public static void drawMap(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {
        Shape shape = new Cycle();
        drawMap(shape);
    }
}

