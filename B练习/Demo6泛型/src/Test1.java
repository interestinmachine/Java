import java.util.ArrayList;
import java.util.List;

class Alg<T extends Comparable<T>> {
    public T findMax(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

class Alg2<T extends Comparable<T>> {
    public static<T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}


public class Test1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        List<? extends Number> list = arrayList1;
        //list.add(0,1); 通配符的上界，不适合写入数据
        Number o = list.get(0);
    }

    public static void main1(String[] args) {
        Integer[] array = {1,2,3,4,5};
        System.out.println(Alg2.findMax(array));
        System.out.println(Alg2.<Integer>findMax(array));
    }
}

