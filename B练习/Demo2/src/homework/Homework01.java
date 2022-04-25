package homework;

public class Homework01 {
    public static void main(String[] args) {
        String str = "abcdef";
        try {
            str = reverse(str,1,4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

    }

    //将字符串中指定部分进行反转，如 a bcde f -> a edcb f
    public static String reverse(String str,int start,int end){
        if (!(str != null && start >= 0 && start < end && end < str.length())){
            throw new RuntimeException("参数不正确");
        }

        char[] chars = str.toCharArray();
        while (start < end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            ++start;
            --end;
        }

        return new String(chars);
    }
}

