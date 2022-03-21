package TestInterFace;

import java.util.Arrays;

/**
 * 接口的使用实例：
 *      一般情况下，自定义类型进行比较 需要是 可比较的。
 *      Comparable      Comparator 有区别！！
 */

class Student implements Comparable<Student>{
    public String name;
    public int age;
    public int score;

    public Student(String name,int age,int score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student: " + this.name +
                ", age: " + this.age +
                ", score: " + this.score + "\n";
    }

    @Override
    public int compareTo(Student o) {
        if (this.age < o.age){
            return 1;
        } else if (this.age == o.age){
            return 0;
        } else {
            return -1;
        }
    }
}

public class useInterFace {
    public static void main(String[] args) {
        Student student1 = new Student("zzy",22,99);
        Student student2 = new Student("glj",23,100);
        Student student3 = new Student("xyc",22,99);

//        if (student1.compareTo(student2) > 0){
//            System.out.println("student2 年龄大于 student1");
//        }

        Student[] students = new Student[3];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}

