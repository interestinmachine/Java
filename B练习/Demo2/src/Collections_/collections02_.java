package Collections_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings({"all"})
public class collections02_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");

        //Object max(Collection) 根据元素的自然顺序，返回给定集合中的最大元素
        System.out.println("自然顺序的最大元素 = " + Collections.max(list));

        //Object max(Collection,Comparator) 根据 Comparator 指定的顺序， 返回给定集合中的最大元素
        //比如返回长度最大的元素
        Object maxObject = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("长度最长的元素="+maxObject);

        //Object min(Collection) 根据元素的自然顺序，返回给定集合中的最小元素
        //Object min(Collection,Comparator) 根据 Comparator 指定的顺序， 返回给定集合中的最小元素
        //此处参考 max 即可

        //int frequency(Collection,Object) 返回指定集合中指定元素的出现次数
        System.out.println("tom出现的次数="+Collections.frequency(list,"tom"));

        //void copy(List dest,List src) 将 src 中的内容复制到 dest 中
        ArrayList dest = new ArrayList();
        //为了完成一次完整的拷贝，我们需要先给dest赋值，大小和list.size()一样
        for(int i = 0; i < list.size(); i++){
            dest.add("");
        }
        //拷贝
        Collections.copy(dest,list);
        System.out.println("dest = " + dest);

        //boolean replaceAll(List list,Object oldVal,Object newVal) 使用新值替换 List 对象的所有值
        Collections.replaceAll(list,"tom","汤姆");
        System.out.println("list替换后 = "+list);
    }
}

