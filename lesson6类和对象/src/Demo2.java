class Student {
    private String myName;
    private int age;

    // 自动生成以下get和set方法：alt+insert，然后选中数据成员


    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 自动生成打印出数据成员的方法：alt+insert，选中toString，再选择打印的数据成员
    // 重新实现了 Object类的 toString()方法
    // Object 是所有类的父类
    @Override // 注解：这个注解指的是 这个方法是重新写的
    public String toString() {
        return "Student{" +
                "myName='" + myName + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Demo2 {
    public static void main(String[] args) {
        Student student = new Student();
        student.setMyName("zzy");
        System.out.println(student); // 使用实例变量，自动调用toString方法
    }
}

