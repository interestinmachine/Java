public class TestPerson {
    public static void main(String[] args) {
        Person1 per = new Person1();
        per.age = 19;
        per.name = "jack";

        Person1 per2 = new Person1();
        per2.age = 19;
        per2.name = "jackl";

        System.out.println(per.compareTo(per2));

    }
}

class Person1{
    String name;
    int age;

    boolean compareTo(Person1 per1){
        if (this.name.equals(per1.name) && this.age == per1.age){
            return true;
        }
        return false;
    }
}

