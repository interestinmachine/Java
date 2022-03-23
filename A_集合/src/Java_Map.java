import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Java_Map {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("腾讯有难","八方点赞");
        map.put("111","aaa");
        map.put("222","xxx");
        System.out.println(map);

        String s = map.get("111");
        System.out.println(s);

        String s1 = map.get("222");
        System.out.println(s1);

        String s2 = map.getOrDefault("222","没有找到");
        System.out.println(s2);

        // key相同的情况下，会存储最新的value值
        map.put("222","bbb");
        System.out.println(map);
        System.out.println("======================================");

        Set<Map.Entry<String,String>> set = map.entrySet();
        System.out.println(set);
        for(Map.Entry<String,String> entry : set){
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}

