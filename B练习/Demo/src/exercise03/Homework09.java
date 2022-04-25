package exercise03;

public class Homework09 {
    public static void main(String[] args) {
        Point point = new Point(1,2);
        LabeledPoint labeledPoint = new LabeledPoint("Black",2,3);
    }
}

class Point{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class LabeledPoint extends Point{
    private String label;
    public LabeledPoint(String label,int x, int y) {
        super(x, y);
        this.label = label;
    }
}

