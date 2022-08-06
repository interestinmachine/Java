package 实现自己的MyArrayList;

public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.display();
        System.out.println("======================");

        myArrayList.add(2,100);
        myArrayList.add(0,999);
        myArrayList.display();
        System.out.println("======================");

        System.out.println(myArrayList.contains(100));
        System.out.println(myArrayList.contains(10000));
        System.out.println("======================");

        System.out.println(myArrayList.indexOf(999));
        System.out.println(myArrayList.indexOf(2));
        System.out.println(myArrayList.indexOf(3));
        System.out.println("======================");

        System.out.println(myArrayList.get(3));
        System.out.println("======================");

        myArrayList.set(3,1234);
        myArrayList.display();
        System.out.println("======================");

        myArrayList.remove(1234);
        myArrayList.display();
        System.out.println("======================");

        System.out.println(myArrayList.size());
        System.out.println("======================");

        myArrayList.clear();
        System.out.println(myArrayList.size());
    }
}

