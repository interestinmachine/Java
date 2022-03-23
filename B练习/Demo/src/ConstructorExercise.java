public class ConstructorExercise {
    public static void main(String[] args) {
        Person per1 = new Person();
        System.out.println(per1.name);
        System.out.println(per1.age);

        Person per2 = new Person("aaa",10);
        System.out.println(per2.name);
        System.out.println(per2.age);


    }

}

class Person{
    public String name;
    public int age;

    public Person(){
        this.age = 18;
    }

    public Person(String pName,int pAge){
        this.name = pName;
        this.age = pAge;
    }
}

