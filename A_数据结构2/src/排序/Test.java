package 排序;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Test {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Integer> ps = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            ps.put(position[i],speed[i]);
        }
        Stack<Float> stk;
        int ans = 0;
        Set<Map.Entry<Integer, Integer>> entrySet = ps.entrySet();
        for (Object entry: entrySet) {
            Map.Entry m = (Map.Entry) entry;
            float time = (float) ((target-m.getKey()) / m.getValue());
        }
    }
}

