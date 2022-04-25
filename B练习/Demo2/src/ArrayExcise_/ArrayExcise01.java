package ArrayExcise_;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayExcise01 {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book("aaa",19.5);
        books[1] = new Book("bbb",23);
        books[2] = new Book("ccc",14);
        books[3] = new Book("ddd",17);
        books[4] = new Book("eee",50);

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double d1 = (Double)o1.getPrice();
                double d2 = (Double)o2.getPrice();
                return (int)(d1 - d2);
            }
        });

        System.out.println(Arrays.toString(books));
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
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
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

