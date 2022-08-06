package 实现自己的MyArrayList;

import java.util.Arrays;

public class MyArrayList {
    public int[] elem;
    public int usedSize;
    private static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }

    //打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    public void capacity() {
        if (isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
        }
    }

    //新增元素，默认在数组最后新增
    public void add(int data) {
        //1. 如果表是满的，则扩容
        capacity();
        //2. 不满则进行插入
        this.elem[usedSize] = data;
        usedSize++;
    }

    //判断当前的顺序表是不是满的
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    //判断位置是否合法
    public boolean posLegal(int pos) {
        if (pos < 0 || pos > usedSize) {
            System.out.println("输入位置不合法！");
            return false;
        }
        return true;
    }

    //在 pos 位置新增元素
    public void add(int pos,int data) {
        if (!posLegal(pos)) {
            return;
        }
        //如果满了则扩容
        capacity();
        for (int i = this.usedSize-1; i >= pos ; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    //判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    //查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //获取 pos 位置的元素
    public int get(int pos) {
        if (!posLegal(pos)) {
            return -1;
        }
        return this.elem[pos];
    }

    //给 pos 位置的元素设为 value
    public void set(int pos,int value) {
        if (!posLegal(pos)) {
            return;
        }
        this.elem[pos] = value;
    }

    //删除第一次出现的关键字 key
    public void remove(int toRemove) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toRemove) {
                for(int j = i+1; j < this.usedSize;++j) {
                    this.elem[j-1] = this.elem[j];
                }
                --this.usedSize;
            }
        }
    }

    //获取 顺序表的长度
    public int size() {
        return this.usedSize;
    }

    //清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}

