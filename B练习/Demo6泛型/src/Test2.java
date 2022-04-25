import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Test2 {
    public static Map<Integer,Integer> func(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x: array) {
            if (map.get(x) == null) {
                map.put(x,1);
            } else {
                int val = map.get(x);
                map.put(x,val+1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] array = new int[1_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        Map<Integer,Integer> map = func(array);
        System.out.println(map);
    }

    public static void main1(String[] args) {
        Map<String ,Integer> mp = new HashMap<>();
        mp.put("abc",3);
        mp.put("bit",2);
        mp.put("hello",4);

        Set<Map.Entry<String,Integer>> entrySet = mp.entrySet();
        for (Map.Entry<String,Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

