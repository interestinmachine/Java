import com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl;

import java.util.*;

public class Test3 {
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        //1. 统计每个单词出现的次数
        for (int i = 0; i < words.length; i++) {
            if (map.get(words[i]) == null) {
                map.put(words[i],1);
            } else {
                int val = map.get(words[i]);
                map.put(words[i],val+1);
            }
        }

        //2. 建立一个大小为 K 的小根堆
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) == 0) {
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue() - o2.getValue();
            }
        });


        //3. 遍历 Map
        for(Map.Entry<String ,Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                //说明堆中 已经放满了 K 个元素，需要看堆顶元素的数据，和当前的数据的大小的关系
                Map.Entry<String ,Integer> top = minHeap.peek();
                //判断频率是否相同，如果相同，比较单词大小，单词小 的入堆
                if (top.getValue().compareTo(entry.getValue()) == 0) {
                    if (top.getKey().compareTo(entry.getKey()) > 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                } else {
                    if (top.getValue().compareTo(entry.getValue()) < 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String ,Integer> top = minHeap.poll();
            ret.add(top.getKey());
        }
        Collections.reverse(ret);
        return  ret;
    }

    public static void main(String[] args) {
        String words[] = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> ret = topKFrequent(words,2);
        System.out.println(ret);

    }
}

