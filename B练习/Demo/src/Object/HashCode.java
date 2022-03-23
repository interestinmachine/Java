package Object;

public class HashCode {
    public static void main(String[] args) {
        String str1 = new String("aaa");
        String str2 = new String("bbb");
        System.out.println("str1的哈希值为：" + str1.hashCode());
        System.out.println("str2的哈希值为：" + str2.hashCode());
        String str3 = str1;
        System.out.println("str3的哈希值为：" + str3.hashCode());
    }
}

