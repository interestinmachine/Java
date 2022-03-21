import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        byte[] bytes = {97,98,99,100};
        String str = new String(bytes);
        System.out.println(str);
        String str2 = "abcdef";
        byte[] bytes1 = str2.getBytes();
        System.out.println(Arrays.toString(bytes1));
    }

    public static boolean func(String str){
        char[] array = str.toCharArray();
        for(char ch : array){
            if (ch>'9' || ch < '0'){
                return false;
            }
        }
        return true;
    }

    public static void main9(String[] args) {
        String str = "1234a56";
        boolean flg = func(str);
        System.out.println(flg);
    }

    public static void main8(String[] args) {
        char[] val = {'a','b','c','d','e'};
        String str1 = new String(val);
        System.out.println(str1);

        String str2 = new String(val,1,3);
        System.out.println(str2);

        char pos = str1.charAt(3);
        System.out.println(pos);

        char[] value = str2.toCharArray();
        System.out.println(value);
    }

    public static void main7(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello").intern();
        System.out.println(str1==str2);

        /**
         * intern() 手动入池，从现象上来看的。
         * 当前的这个字符串是否在常量池中？如果存在，把常量池当中的引用赋值给当前引用类型的变量
         */
    }

    public static void main6(String[] args) {
        String str1 = null;
        String str2 = new String("hello");
        //System.out.println(str1.equals(str2)); 报错,空引用访问

        // 建议写成
        System.out.println(str2.equals(str1));
        //或者是
        System.out.println("hello".equals(str1));
    }

    public static void main5(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1==str2); // 比较的是引用
        System.out.println(str1.equals(str2)); // 比较的是字符串的内容
    }

    public static void func(String str,char[] val){
        str = "abcdef";
        val[0] = 'g';
    }

    public static void main4(String[] args) {
        String str1 = "1111";
        char[] val = {'a'};
        System.out.println(str1); // 1111
        System.out.println(Arrays.toString(val)); // a
        func(str1,val);
        System.out.println(str1); // 1111
        System.out.println(Arrays.toString(val)); // g
    }

    public static void main3(String[] args) {
        String str1 = "hello";
        String str2 = "hel" + "lo";
        System.out.println(str1==str2); // true
        String str3 = new String("hel") + "lo";
        System.out.println(str1==str3); // false
    }

    public static void main2(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1==str2); //true

        String str3 = new String("hello");
        String str4 = new String("hello");
        System.out.println(str3==str4); //false
    }

    public static void main1(String[] args) {
        //创建String的方法

        //方式一
        String str = "hello bit";

        //方式二
        String str2 = new String("hello bit");

        //方式三
        char[] array = {'a', 'b', 'c'};
        String str3 = new String(array);

        System.out.println(str);
        System.out.println(str2);
        System.out.println(str3);
    }
}

