package reflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class ReflectClassDemo {
    //通过Class类的newInstance方法 获取 学生实例
    public static void reflectNewInstance() {
        try {
            Class<?> c1 = Class.forName("reflectDemo.Student");

            Student student = (Student) c1.newInstance();
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reflectPrivateConstructor() {
        try {
            Class<?> c1 = Class.forName("reflectDemo.Student");
            Constructor<?> constructor = c1.getDeclaredConstructor(String.class, int.class);

            constructor.setAccessible(true);//修改访问权限

            Student student = (Student) constructor.newInstance("zzy", 23);
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射属性 获取私有 或者 公开的属性
    public static void reflectPrivateField() {
        try {
            Class<?> c1 = Class.forName("reflectDemo.Student");

            Student student = (Student) c1.newInstance();

            Field field = c1.getDeclaredField("name");//获取名为 name 的字段
            field.setAccessible(true);

            field.set(student,"zhangsan");

            System.out.println(student);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reflectPrivateMethod() {
        try {
            Class<?> c1 = Class.forName("reflectDemo.Student");

            Student student = (Student) c1.newInstance();

            Method method = c1.getDeclaredMethod("eat",String.class);

            method.setAccessible(true);

            method.invoke(student,"apple");

            System.out.println(student);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //reflectNewInstance();
        //reflectPrivateConstructor();
        //reflectPrivateField();
        reflectPrivateMethod();
    }
}


