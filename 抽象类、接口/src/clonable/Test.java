package clonable;

import java.util.Arrays;

class Money implements Cloneable{
    public double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    public int age;
    Money m = new Money();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        //1.克隆person
        Person p = (Person)super.clone();
        //2.克隆当前的Money对象
        p.m = (Money)this.m.clone();
        return p;
    }
}

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        Person person2 = (Person)person1.clone();
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
        System.out.println("===========修改后==============");
        person2.m.money = 99.9;
        System.out.println(person1.m.money);
        System.out.println(person2.m.money);
    }

    public static void main2(String[] args) throws CloneNotSupportedException{
        Person person1 = new Person();
        Person person2 = (Person)person1.clone();
        System.out.println(person1.age);
        System.out.println(person2.age);
        System.out.println("===========修改后==============");
        person2.age = 100;
        System.out.println(person1.age);
        System.out.println(person2.age);
    }

    public static void main1(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = arr1.clone();
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println("============修改后============");
        arr2[0] = 100;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}

