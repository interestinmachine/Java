import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Java_Collection {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("bit");
        collection.add("Java");
        System.out.println(collection);
        collection.clear();
        System.out.println(collection);
        System.out.println(collection.isEmpty());

        collection.add("123");
        collection.add("456");
        collection.add("789");
        System.out.println(collection.remove("123"));
        System.out.println(collection);
        System.out.println(collection.size());

        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));
    }
}

