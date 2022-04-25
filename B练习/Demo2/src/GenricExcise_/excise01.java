package GenricExcise_;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class excise01 {
    public static void main(String[] args) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList.add(new Employee("tom",1800,new MyDate(1999,2,2)));
        arrayList.add(new Employee("jack",3000,new MyDate(1996,3,12)));
        arrayList.add(new Employee("tom",20000,new MyDate(1968,7,24)));

        System.out.println(arrayList);
        arrayList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1 instanceof Employee && o2 instanceof Employee)){
                    System.out.println("类型不正确");
                    return 0;
                }

                //比较name
                int i1 = o1.getName().compareTo(o2.getName());
                if (i1 != 0) {
                    return i1;
                }

                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        System.out.println("排序后：");
        System.out.println(arrayList);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        setName(name);
        setSal(sal);
        setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int month;
    private int day;
    private int year;

    public MyDate(int year, int month, int day) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(MyDate o){
        //如果name相同，比较birthday - year
        int yearMinus = year - o.getYear();
        if (yearMinus != 0){
            return yearMinus;
        }
        //如果year相同，就比较month
        int monthMinus = month - o.getMonth();
        if (monthMinus != 0){
            return monthMinus;
        }
        //如果month，比较day
        return day - o.getDay();
    }
}

