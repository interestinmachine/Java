package innerclass;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        //外部其他类，使用成员内部类的两种方式

        //第一种
        Outer08 outer08 = new Outer08();
        // outer08.new Inner08(); 相当于把 new Inner08() 当做是outer08的成员
        // 这就是和语法，不用太纠结
        Outer08.Inner08 inner08 = outer08.new Inner08();

        // 第二种：在外部类中，编写一个方法，可以返回 Inner08 的对象
        Outer08.Inner08 inner08__ = outer08.getInner08Instance();
        inner08__.say();
    }
}

class Outer08 { // 外部类
    private int n1 = 10;
    public String name = "张三";

    // 注意：成员内部类，是定义在外部类内的成员位置上的
    class Inner08 {
        public void say() {
            //可以直接访问外部类的所有成员，包含私有
            System.out.println("n1 = " + n1 + " name = " + name);
        }
    }

    //方法：返回一个Inner08的实例
    public Inner08 getInner08Instance(){
        return new Inner08();
    }

    //写方法
    public void t1() {
        Inner08 inner08 = new Inner08();
        inner08.say();
    }
}
