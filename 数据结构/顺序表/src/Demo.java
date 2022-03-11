import java.util.Arrays;

class SeqList {
    public int[] elem;
    public int uesdSize; //有效数据的个数

    public SeqList() {
        this.elem = new int[10];
        this.uesdSize = 0;
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.uesdSize; ++i) {
            System.out.println(this.elem[i] + " ");
        }
        System.out.println();
    }

    public boolean isFull() {
        return this.uesdSize == this.elem.length;
    }

    // 在pos位置新增元素
    public void add(int pos, int data) {
        if (pos < 0 || pos > this.uesdSize) {
            System.out.println("pos 位置不合法！");
            return;
        }

        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }

        for (int i = this.uesdSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        ++this.uesdSize;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.uesdSize; ++i) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.uesdSize; ++i) {
            if (this.elem[i] == toFind)
            {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.uesdSize == 0;
    }

    // 获取pos位置的元素
    public int getPos(int pos) {
        if (pos < 0 || pos > this.uesdSize) {
            System.out.println("pos 位置不合适");
            return -1;
        }

        if (isEmpty()) {
            System.out.println("顺序表为空！");
            return -1;
        }
        return this.elem[pos];
    }

    // 给pos位置的元素设为/更新为value
    public void setPos(int pos, int value) {
        if (pos < 0 || pos > this.uesdSize) {
            System.out.println("pos位置不合法！");
            return;
        }

        if (isEmpty()) {
            return;
        }
        this.elem[pos] = value;
    }

    // 删除第一次出现的关键字key
    public void remove(int toRemove) {
        if (isEmpty()) {
            System.out.println("顺序表为空！");
            return;
        }

        int index = search(toRemove);
        if (index == -1) {
            System.out.println("没有你要删除的元素！");
            return;
        }

        for (int i = index; i < this.uesdSize; ++i) {
            this.elem[i] = this.elem[i+1];
        }
        this.uesdSize--;
        // this.elem[usedSize] = null; 如果数组当中是引用数据类型
    }

    // 获取顺序表长度
    public int size() {
        return this.uesdSize;
    }

    // 清空顺序表
    public void clear() {
        this.uesdSize = 0;
        //如果数组当中是引用数据类型。
//        for (int i = 0; i < this.uesdSize; i++) {
//            this.elem[i] = null;
//        }
//        this.uesdSize = 0;
    }
}

public class Demo {
    public static void main(String[] args) {
        SeqList seq = new SeqList();
        seq.add(0,1);
        seq.add(1,10);
        seq.add(2,100);
        seq.add(3,1000);
        seq.remove(100);
        System.out.println(seq.contains(1000));
        // seq.display();
    }
}
