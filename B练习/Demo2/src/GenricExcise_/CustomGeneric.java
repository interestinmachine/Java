package GenricExcise_;

import java.util.ArrayList;
import java.util.List;

public class CustomGeneric {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();

        //如果是 List<?> c，可以接受任意的泛型类型
        printCollection(list1);
        printCollection(list2);
        printCollection(list3);
        printCollection(list4);
        printCollection(list5);

        //printCollection2(list1); Object不是AA的子类
        //printCollection2(list2); String不是AA的子类
        printCollection2(list3);
        printCollection2(list4);
        printCollection2(list5);

        printCollection3(list1);
        //printCollection3(list2);
        printCollection3(list3);
        //printCollection3(list4);
        //printCollection3(list5);
    }

    //说明：List<?> 表示 任意的泛型类型都可以接受
    public static void printCollection(List<?> c) {
        for (Object o : c) { //通配符，取出时，就是 Object
            System.out.println(o);
        }
    }

    // ? extends AA 表示 上限，可以接受 AA 或者 AA子类
    public static void printCollection2(List<? extends AA> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }

    // ? super 子类类名AA 表示支持AA类以及AA类的父类，不限于直接父类
    public static void printCollection3(List<? super AA> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }
}

class AA{}
class BB extends AA{}
class CC extends AA{}

