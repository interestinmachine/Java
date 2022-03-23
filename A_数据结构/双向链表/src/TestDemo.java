public class TestDemo {
    public static void main(String[] args) {
        MyDoubleLinkedList dL1 = new MyDoubleLinkedList();
        dL1.addFirst(1);
        dL1.addFirst(2);
        dL1.addFirst(3);
        System.out.print("验证头插法：");
        dL1.display();

        dL1.addLast(4);
        dL1.addLast(5);
        dL1.addLast(6);
        System.out.print("验证尾插法：");
        dL1.display();

        dL1.addIndex(0,-1);
        System.out.print("验证在0号下标插入：");
        dL1.display();

        dL1.addIndex(7,10);
        System.out.print("验证在末尾插入：");
        dL1.display();

        dL1.addIndex(2,100);
        System.out.print("验证在中间位置插入：");
        dL1.display();

        System.out.print("验证是否包含关键字2：");
        System.out.println(dL1.contains(2));

        int del = dL1.remove(100);
        System.out.print("验证删除关键字为100：");
        dL1.display();
        System.out.println("删除的关键字为：" + del);

        dL1.addFirst(1);
        System.out.print("向链表添加1后：");
        dL1.display();
        dL1.removeAllKey(1);
        System.out.print("验证删除所有为1的关键字：");
        dL1.display();

        System.out.println("现在链表的大小为：" + dL1.size());
    }
}

