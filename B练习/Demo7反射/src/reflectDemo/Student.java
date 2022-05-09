package reflectDemo;

public class Student {
    private String name = "zhaohenyu";
    public int age = 109;

    public Student() {
        System.out.println("Student()");
    }

    private Student(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(String,name)");
    }

    private void eat(String food) {
        System.out.println(this.name + " 正在吃" + food);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

