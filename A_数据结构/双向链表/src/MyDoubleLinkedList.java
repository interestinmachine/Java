class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode(int data){
        this.val = data;
    }
}

public class MyDoubleLinkedList {
    public ListNode head; //双向链表的头
    public ListNode tail; // 双向链表的尾

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if (this.head == null){
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if (this.head == null){
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }

    private void checkIndex(int index){
        if (index < 0 || index > this.size()){
            throw new RuntimeException("index不合法");
        }
    }

    private ListNode searchIndex(int index){
        ListNode cur = this.head;
        while (index != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //任意位置插入，第一个数据节点下标为0
    public void addIndex(int index,int data){
        checkIndex(index);
        if (index == 0){
            addFirst(data);
            return;
        }
        if (index == this.size()){
            addLast(data);
            return;
        }

        ListNode node = new ListNode(data);
        ListNode cur = searchIndex(index);
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
    }

    //查找是否包含关键字key在双向链表中
    public boolean contains(int key){
        ListNode cur = this.head;
        while (cur != null){
            if (cur.val == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public int remove(int key){
        ListNode cur = this.head;
        while (cur != null){
            if (cur.val == key){
                int oldVal = cur.val;
                if (cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null){
                        cur.next.prev = cur.prev;
                    } else {
                        //删除的是尾巴节点，只需修改tail
                        this.tail = cur.prev;
                    }
                }
                return oldVal;
            }
            cur = cur.next;
        }
        return -1;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur = this.head;
        while (cur != null){
            if (cur.val == key){
                if (cur == this.head){
                    this.head = this.head.next;
                    if (this.head != null){
                        this.head.prev = null;
                    }
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null){
                        cur.next.prev = cur.prev;
                    } else {
                        //删除的是尾巴节点，只需修改tail
                        this.tail = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    public int size(){
        int count = 0;
        ListNode cur = this.head;
        while (cur != null){
            ++count;
            cur = cur.next;
        }
        return count;
    }

    public void display(){
        ListNode cur = this.head;
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //需要一个一个节点进行释放
    public void clear(){
        while(this.head != null){
            ListNode cur = this.head.next;
            this.head.prev = null;
            this.head.next = null;
            this.head = cur;
        }
        this.tail = null;
    }
}