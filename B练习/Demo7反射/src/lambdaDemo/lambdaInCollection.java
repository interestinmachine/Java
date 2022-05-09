package lambdaDemo;

import java.util.ArrayList;
import java.util.function.Consumer;

public class lambdaInCollection {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("HELLO");
        list.add("zzy");
        list.add("lambda");
        list.add("hello");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + " ");
            }
        });

        System.out.println("===================");
        list.forEach(s->{
            System.out.println(s + " ");
        });
    }
}

