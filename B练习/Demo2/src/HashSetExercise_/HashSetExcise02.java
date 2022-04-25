package HashSetExercise_;

import java.util.HashSet;
import java.util.Objects;

/**
 * 定义一个Employee类，该类包含：private成员属性name，sal,birthday(MyDate类型），
 * 其中birthday 为 MyDate类型（属性包含：year，month，day），要求：
 * 1. 创建3个Employee放入HashSet中
 * 2。 当 name 和 age 的值相同时，认为是相同员工，不能添加到HashSet集合中
 */

public class HashSetExcise02 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

    }
}

class Employee2 {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee2(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee2 employee2 = (Employee2) o;
        return Objects.equals(name, employee2.name) && Objects.equals(birthday, employee2.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


}

