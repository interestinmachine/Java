public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList List = new MyLinkedList();
        List.addFirst(1);
        List.addFirst(2);
        List.addFirst(3);
        List.addLast(5);
        List.addLast(4);
        List.addLast(3);
        List.display();

        System.out.println("是否包含5：" + List.contains(5));
        System.out.println("链表的大小为：" + List.size());

        System.out.print("插入12到链首：");
        List.addIndex(0,12); //插在链首
        List.display();
        System.out.print("插入30到下标为6的位置：");
        List.addIndex(6,30); //插在链尾
        List.display();

        MyLinkedList List2 = new MyLinkedList();
        System.out.print("空链表时插入元素：");
        List2.addIndex(0,-15); //空节点时插入数据
        List2.display();

        MyLinkedList List3 = new MyLinkedList();
        List3.addLast(1);
        List3.addLast(2);
        List3.addLast(3);
        List3.addLast(4);
        System.out.print("链表3为：");
        List3.display();

        System.out.print("移除数字1：");
        List3.remove(1);
        List3.display();

        System.out.print("移除数字4：");
        List3.remove(4);
        List3.display();

        System.out.print("移除不存在的数字1:");
        List3.remove(1);
        List3.clear();
        System.out.println();

        MyLinkedList List4 = new MyLinkedList();
        List4.addLast(1);
        List4.addLast(3);
        List4.addLast(2);
        List4.addLast(2);
        List4.addLast(1);
        List4.addLast(2);
        System.out.print("List4的数据为：");
        List4.display();
        System.out.print("删除所有值为2的结点：");
        List4.removeAllKey(2);
        List4.display();
        System.out.println();



    }
}

