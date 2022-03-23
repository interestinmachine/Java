// 创建单链表结点
class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

// 无头单向非循环链表
public class MyLinkedList {
    public ListNode head; // 保存单链表的头结点的引用

    // 头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            // 第一次插入结点
            this.head = node;
            return;
        }
        node.next = this.head;
        head = node;
    }

    // 尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        ListNode tail = this.head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    // 在index位置插入，第一个数据结点为0号下标
    public void addIndex(int index,int data) {
        if (index < 0 || index > this.size()) {
            System.out.println("请输入正确的位置！");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == this.size()) {
            addLast(data);
            return;
        }

        ListNode node = new ListNode(data);
        //找到index-1位置的结点
        ListNode cur = findIndex(index);
        node.next = cur.next;
        cur.next = node;
    }

    // 找到index-1位置的结点的地址
    public ListNode findIndex(int index) {
        if (index < 0 || index > this.size()) {
            throw new RuntimeException("index位置不合法");
        }
        ListNode cur = this.head;
        while (index-1 != 0) {
            cur = cur.next;
            --index;
        }
        return cur;
    }

    public ListNode searchPrev(int key) {
        ListNode cur = this.head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    // 删除第一次出现关键字为key的结点
    public void remove(int key) {
        if (this.head == null) {
            System.out.println("单链表为空，不能删除！");
            return;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        ListNode prev = searchPrev(key);
        if (prev == null) {
            System.out.println("没有这个结点");
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
    }

    // 删除所有值为key的结点
    public void removeAllKey(int key) {
        if (this.head == null) {
            System.out.println("链表为空，无法删除结点");
            return;
        }
        ListNode prev = this.head;
        ListNode cur = this.head.next; //代表要删除的结点
        while (cur != null) {
            if (cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.val == key) {
            this.head = this.head.next;
        }
    }

    // 查找是否包含关键字key
    public boolean contains(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 得到单链表的长度
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while (cur != null) {
            ++count;
            cur = cur.next;
        }
        return  count;
    }

    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        this.head = null;
    }


}


