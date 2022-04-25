package abstract_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        Manager manager = new Manager("赵四",1122,10000,500);
        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee("张三",4321,5000);
        commonEmployee.work();
    }
}

abstract class Employee{
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();
}

class Manager extends Employee{
    private double bonus;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("Manager 在工作");
    }
}

class CommonEmployee extends Employee{
    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("普通员工在工作");
    }
}