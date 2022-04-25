package HashSetExercise_;

import java.util.HashSet;
import java.util.Objects;

/**
 * 定义一个Employee类，该类包含：private成员属性name，age，要求：
 * 1. 创建3个Employee放入HashSet中
 * 2。 当 name 和 age 的值相同时，认为是相同员工，不能添加到HashSet集合中
 */
@SuppressWarnings({"all"})
public class HashSetExcise {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("aa",18));
        hashSet.add(new Employee("aa",18));
        hashSet.add(new Employee("bb",19));

        System.out.println(hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

