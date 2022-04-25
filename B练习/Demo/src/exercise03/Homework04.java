package exercise03;

import java.util.PrimitiveIterator;

public class Homework04 {
    public static void main(String[] args) {
        Employee employee = new N_Employee("张三",500,30);
        System.out.println(employee.printSalary());

        Employee manager = new branch_manager("李四",1000,28);
        System.out.println(manager.printSalary());
    }
}

class Employee{
    private String name;
    private double salary_day;
    private int workday;

    public Employee(String name, double salary_day, int workday) {
        this.name = name;
        this.salary_day = salary_day;
        this.workday = workday;
    }

    public double printSalary(){
        return this.salary_day * this.workday;
    }
}

class N_Employee extends Employee{
    public N_Employee(String name, double salary_day, int workday) {
        super(name, salary_day, workday);
    }

    @Override
    public double printSalary() {
        return super.printSalary();
    }
}

class branch_manager extends Employee{
    public branch_manager(String name, double salary_day, int workday) {
        super(name, salary_day, workday);
    }

    @Override
    public double printSalary() {
        return super.printSalary()*1.2+1000;
    }
}
