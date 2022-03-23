package exercise02;

public class Person {
    private String name;
    private int age;

    public Person(){}

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String say(){
        return "hello, my name is " + this.name + " and i am " + this.age +
                "years old.";
    }
}

