package exercise03;

import java.util.Arrays;

public class Homework01 {
    public static void main(String[] args) {
        Person person1 = new Person("suxi",20,"it");
        Person person2 = new Person("jack",19,"waiter");
        Person person3 = new Person("aconad",22,"farmer");
        Person[] person = {person1,person2,person3};
        sort(person);
        System.out.println(Arrays.toString(person));
    }

    public static void sort(Person[] person){
        for(int i = 0; i < person.length-1; ++i){
            for(int j = 0;j < person.length-1-i; ++j){
                if (person[j].getAge() < person[j+1].getAge()){
                    Person tmp = person[j];
                    person[j] = person[j+1];
                    person[j+1] = tmp;
                }
            }
        }
    }
}

class Person{
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job){
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "name = " + this.name + "\tage = " + this.age + "\tjob = " + this.job;
    }
}

