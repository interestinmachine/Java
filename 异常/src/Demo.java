class Person implements Cloneable {
    public int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

// 自定义异常类
//必须要继承一个父类
class MyException extends Exception {
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}

public class Demo {
    // 使用自定义异常类型
    public static void func1(int x) throws MyException {
        if (x == 10){
            throw new MyException("x==10");
        }
    }

    public static void main(String[] args) {
        try {
            func1(10);
        } catch (MyException e){
            e.printStackTrace();
        }
    }

    public static void main3(String[] args) {
        Person person1 = new Person();
        try {
            Person person2 = (Person)person1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static int func(){
        int[] arr = new int[]{1,2,3};
        try {
            System.out.println(arr[4]);
            return 0;
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("这是异常处理块");
            return 1;
        } finally {
            System.out.println("这是finally语句块");
            return 2;
        }
    }

    public static void main2(String[] args) {
        System.out.println(func());
    }

    public static void main1(String[] args) {
        int[] arr = new int[]{1,2,3};
        arr = null;
        try {
            System.out.println(arr[4]);
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("访问数组越界了！");
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("访问空引用了！");
        }



    }
}

