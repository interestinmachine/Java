package MapExcise_;

import java.util.*;

@SuppressWarnings({"all"})
public class MapExcise {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Employee employee1 = new Employee("aaa",20000,123);
        Employee employee2 = new Employee("bbb",17000,456);
        Employee employee3 = new Employee("ccc",30000,789);
        hashMap.put(employee1.getId(),employee1);
        hashMap.put(employee2.getId(),employee2);
        hashMap.put(employee3.getId(),employee3);

        Collection values = hashMap.values();
        //1.增强for
        for (Object value : values){
            Employee employee = (Employee) value;
            if (((Employee) value).getSal() > 18000){
                System.out.println(employee);
            }
        }

        System.out.println();
        //2.迭代器
        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            Object value =  iterator.next();
            Employee employee = (Employee) value;
            if (employee.getSal() > 18000){
                System.out.println(employee);
            }

        }

        Set keySet = hashMap.keySet();
        for (Object key : keySet){
            Employee employee = (Employee) hashMap.get(key);
            if (employee.getSal() > 18000){
                System.out.println(employee);
            }
        }

        Set entrySet = hashMap.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Map.Entry entry =  (Map.Entry)iterator1.next();
            Employee employee = (Employee) entry.getValue();
            if (employee.getSal() > 18000){
                System.out.println(employee);
            }

        }
    }
}

class Employee {
    private final String name;
    private final double sal;
    private final int id;

    public Employee(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}



