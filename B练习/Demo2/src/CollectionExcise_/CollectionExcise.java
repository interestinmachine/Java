package CollectionExcise_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionExcise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Dog("小花",5));
        col.add(new Dog("小圆",7));
        col.add(new Dog("小胖",3));

        Iterator iterator = col.iterator();

        System.out.println("====迭代器遍历=====");
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

        System.out.println("====增强for遍历====");
        for(Object dog : col){
            System.out.println(dog);
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

