package Enum_;

public class Enum02 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
    }
}

//演示自定义枚举类实现
class Season {
    private String name;
    private String desc;//描述

    //定义四个对象
    public static final Season SPRING = new Season("春天","温暖");
    public static final Season SUMMER = new Season("夏天","炎热");
    public static final Season AUTUMN = new Season("秋天","凉爽");
    public static final Season WINTER = new Season("冬天","寒冷");

    //1.将构造器私有化，目的防止 直接new
    //2.去掉set方法，防止属性被修改
    //3.在 Season 内部，直接创建固定的对象
    //4.优化：可以加入 final 修饰符
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

