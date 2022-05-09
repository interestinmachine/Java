import java.sql.PreparedStatement;

public class HashBuck<K,V> {
    static class Node<K,V> {
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K,V>[] array = (Node<K,V>[])new Node[10];
    public static final double DEFAULT_LOAD_FACTOR = 0.75;//负载因子
    public int usedSize;

    public void put(K key,V val) {
        int hash = key.hashCode(); // hashCode 确定位置
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        //检查有无key相同的元素，有就更新 val 值
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        Node<K,V> node = new Node<>(key,val);
        //头插法插入元素
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        //检查当前的负载因子
        if (loadFactor() > DEFAULT_LOAD_FACTOR) {
            resize();//扩容
        }
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

    private double loadFactor() {
        return 1.0 * this.usedSize / array.length;
    }

    private void resize(){
        Node[] newArray = new Node[this.array.length*2];
        for (int i = 0; i < this.array.length; i++) {
            Node cur = this.array[i];
            while(cur!=null){
                // 获取 在 新数组中的 存储位置。
                int hash = cur.key.hashCode();
                int index = hash % newArray.length;
                // 头插到新数组中
                Node curNext = cur.next;// 记录下一个节点的位置
                cur.next = newArray[index];
                newArray[index] =  cur;
                cur = curNext;// 接着下一个节点。
            }
            // while循环执行完之后，for循环i++，继续下一个下标的哈希
        }
        // 最后更新引用 array 的指向
        this.array = newArray;
    }

}

