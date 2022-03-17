package Demo4;

/**
 * 理解多态
 */

class Shape {
    public void draw() {

    }
}

class Cycle extends Shape {
    @Override
    public void draw(){
        System.out.println("画一个○");
    }
}

class React extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个矩形");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个△");
    }
}

public class Demo1 {
    public static void drawMap(Shape shape) {
        shape.draw();
    }


    public static void main(String[] args) {
        Shape shape1 = new Cycle();
        Shape shape2 = new React();
        drawMap(shape1);
        drawMap(shape2);
    }

}



