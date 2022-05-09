package reflectDemo;

public class reflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("reflectDemo.Student");

        Class<?> c2 = Student.class;

        Student student = new Student();
        Class<?> c3 = student.getClass();

        System.out.println(c1==c2);
        System.out.println(c1==c3);
        System.out.println(c2==c3);
    }
}

