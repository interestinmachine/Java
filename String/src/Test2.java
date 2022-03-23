public class Test2 {
    /**
     * StringBuffer或者StringBuilder -> String
     * 调用toString方法
     * @param args
     */
    public static String func(){
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

    /**
     * String -> StringBuffer或者StringBuilder
     * 调用构造方法
     * @param args
     */
    public static StringBuilder func1(){
        String strings = new String();
        return new StringBuilder(strings);
    }


    public static void main5(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Abcd");
        sb.append("1211").append("bbbb");
        System.out.println(sb);
    }

    public static void main4(String[] args) {
        String str1 = "  abc d e f  g   ";
        String res = str1.trim();
        System.out.println(res);
    }

    public static void main3(String[] args) {
        String str = "2547492699@qq.com";
        String[] ret = str.split("@");
        for(String s : ret){
            System.out.println(s);
        }

        String str2 = "192.168.1.1";
        String[] res = str2.split("\\.");
        for(String s : res){
            System.out.println(s);
        }

        String str3 = "java30 12&21#hello";
        String[] strings = str3.split(" |&|#");
        for(String s : strings){
            System.out.println(s);
        }
    }

    public static void main2(String[] args) {
        String str = "ababcabcd";
        String tmp = "abc";
        System.out.println(str.indexOf(tmp,3));
        System.out.println(str.lastIndexOf(tmp));

    }

    public static void main1(String[] args) {
        String str1 = "ABCDef";
        String str2 = "abcdef";
        System.out.println(str1.equalsIgnoreCase(str2)); // 忽略大小写比较内容

        String str3 = "abc";
        String str4 = "abcdefg";
        System.out.println(str3.compareTo(str4));
    }
}

