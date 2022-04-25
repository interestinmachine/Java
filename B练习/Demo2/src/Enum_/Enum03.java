package Enum_;

public class Enum03 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
    }
}

enum Season2 {

    //如果使用 enum 来实现枚举类
    //1. 使用关键字 enum 替换 class
    //2. public static final Season SPRING = new Season("春天","温暖");直接使用
    //   SPRING("春天","温暖");
    //3. 如果有多个常量（对象），使用 逗号间隔即可。
    //4. 如果使用 enum 来实现枚举类，要求将定义的常量对象写在最前面。
    //5. 如果我们使用的是无参构造器，创建常量对象，则可以省略()
    SPRING("春天","温暖"),
    SUMMER("夏天","炎热"),
    What;

    private String name;
    private String desc;//描述

    private Season2(){

    }

    private Season2(String name, String desc) {
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




