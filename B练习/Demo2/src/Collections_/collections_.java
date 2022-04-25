package Collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings({"all"})
public class collections_ {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");

        //reverse(List) 反转 List 中元素的顺序
        Collections.reverse(list);
        System.out.println("list = " + list);

        //shuffle(List) 对 List 集合元素进行随机的排序
        Collections.shuffle(list);
        System.out.println("list = " + list);

        //sort(List) 根据元素的自然顺序对指定 List 集合元素按升序排序
        System.out.println("自然排序后：");
        Collections.sort(list);
        System.out.println("list = " + list);

        //sort(List,Comparator) 根据指定的 Comparator 产生的顺序对 List 集合排序
        //比如，字符串的长度大小排序
        System.out.println("按字符串长度排序后：");
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //可以加入校验代码
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println(list);

        System.out.println("交换位置0和1的元素后：");
        //swap(List,int,int) 将指定 List 集合中的 i 处元素和 j 处元素进行互换
        Collections.swap(list,0,1);
        System.out.println(list);
    }
}

