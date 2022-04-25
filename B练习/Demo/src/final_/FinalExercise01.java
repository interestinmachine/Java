package final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle(3);
        System.out.println(circle.calArea());
    }
}

class Circle{
    private double radius;
    // final 变量赋值方法一：
    private final double PI = 3.14;

    // final 变量赋值方法二：
    private final double PI2;
    public Circle(double radius){
        this.radius = radius;
        PI2 = 3.14;
    }

    // final 变量赋值方法三：
    private final double PI3;
    {
        PI3 = 3.14;
    }

    public double calArea(){
        return PI*radius*radius;
    }
}

