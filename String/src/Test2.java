public class Test2 {
    public static void main(String[] args) {
        String str1 = "ABCDef";
        String str2 = "abcdef";
        System.out.println(str1.equalsIgnoreCase(str2)); // 忽略大小写比较内容

        String str3 = "abc";
        String str4 = "abcdefg";
        System.out.println(str3.compareTo(str4));
    }
}

