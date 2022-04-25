package Map;

import java.util.*;

@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超","孙俪");
        map.put("王宝强","马蓉");
        map.put("宋吉","马蓉");
        map.put("aaa",null);
        map.put(null,"刘亦菲");

        //第一组：先取出 所有的Key，通过Key 取出对应的Value
        Set keyset = map.keySet();
        System.out.println("======================第一组=========================");
        //(1) 增强for
        System.out.println("===========增强for=========");
        for(Object key : keyset){
            System.out.println(key + "-" + map.get(key));
        }

        //(2) 迭代器
        System.out.println("=========迭代器=========");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

        System.out.println();
        //第二组：把所有的values取出
        Collection values = map.values();
        System.out.println("======================第二组=========================");
        //这里可以使用所有Collection使用的遍历方式
        //(1) 增强for
        System.out.println("===========增强for===========");
        for (Object value : values){
            System.out.println(value);
        }

        //(2) 迭代器
        System.out.println("==========迭代器============");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value =  iterator1.next();
            System.out.println(value);
        }

        System.out.println();
        System.out.println("======================第三组=========================");
        //第三组：通过EntrySet 来获取 k-v
        Set entrySet = map.entrySet();
        //(1) 增强for
        System.out.println("=========增强for=========");
        for (Object entry : entrySet){
            //将entry 转成 Map.Entry
            Map.Entry m = (Map.Entry)entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }

        //(2) 迭代器
        System.out.println("=========迭代器=========");
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object entry =  iterator2.next();
            //System.out.println(entry.getClass());//HashMap$Node -实现-> Map.Entry(getKey,getValue)
            //向下转型 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }
}

