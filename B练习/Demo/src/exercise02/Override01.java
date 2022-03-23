package exercise02;

public class Override01 {
    public static void main(String[] args) {
        Person person = new Person("Jack",18);
        System.out.println(person.say());
        Student student = new Student("lucy",20,89201,90);
        System.out.println(student.say());

    }
}

