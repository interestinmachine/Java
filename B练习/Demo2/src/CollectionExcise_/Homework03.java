package CollectionExcise_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class Homework03 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("jack",650);
        hashMap.put("tom",1200);
        hashMap.put("smith",2900);

        hashMap.put("jack",2600);
        System.out.println(hashMap);

        Set keySet = hashMap.keySet();
        for(Object key : keySet){
            hashMap.put(key,(Integer)hashMap.get(key)+100);
        }
        System.out.println(hashMap);

        //遍历
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry next =  (Map.Entry)iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }
    }
}



