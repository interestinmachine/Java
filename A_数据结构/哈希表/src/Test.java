import java.util.Objects;

class Person {
    public String id;

    public Person(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person("123");
        Person person2 = new Person("123");

        HashBuck<Person,String> hashBuck = new HashBuck<>();
        hashBuck.put(person1,"bit");
        System.out.println(hashBuck.get(person2));
    }
}

