package innerclass;

public class InnerClassExercise01 {
    public static void main(String[] args) {

        //当做实参直接传递，简洁高效
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("这是一幅名画...");
            }
        });

        //传统写法
        f1(new Picture());
    }

    //静态方法，形参是接口类型
    private static void f1(IL il) {
        il.show();
    }
}

//接口
interface IL {
    void show();
}

//类 -> 实现IL =》编程实现（硬编码）
class Picture implements IL {
    @Override
    public void show() {
        System.out.println("这是一幅名画...");
    }
}

