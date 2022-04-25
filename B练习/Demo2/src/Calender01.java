import java.util.Calendar;

public class Calender01 {
    public static void main(String[] args) {

        //1. Calendar 是一个抽象类，并且构造器是 private
        //2. 可以通过 getInstance() 来获取实例
        //3. 提供大量的方法和字段给程序员
        //4. 如果我们需要按照 24小时进制来获取时间，Calendar.HOUR ==改成==> Calendar.HOUR_OF_DAY
        Calendar c = Calendar.getInstance(); // 创建日期类对象
        System.out.println("c = " + c);

        //2. 获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        System.out.println("月：" + (c.get(Calendar.MONTH))+1);
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c.get(Calendar.HOUR));
        System.out.println("分钟：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));

        //Calendar 没有专门的格式化方法，所以需要程序员自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "年-" + c.get(Calendar.MONTH) + "月");
    }
}

