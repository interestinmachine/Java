package CollectionExcise_;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings({"all"})
public class Homework02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Car("宝马",4000000));
        arrayList.add(new Car("宾利",5000000));

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object car =  iterator.next();
            System.out.println(car);
        }
        System.out.println("======================");
        for (Object car : arrayList){
            System.out.println(car);
        }

        System.out.println("=======================");
        for(int i = 0; i < arrayList.size(); ++i){
            Object car = arrayList.get(i);
            System.out.println(car);
        }
    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

