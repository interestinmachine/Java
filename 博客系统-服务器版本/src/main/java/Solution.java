public class Solution {
    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder str = new StringBuilder();
        for (int i =0;i<s.length();i++) {
            if (s.charAt(i) == ' ') {
                str.append(" ");
            }
        }

        if (str.length() == 0) {
            return s;
        }

        int left = s.length() - 1;
        s += str.toString();
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left >= 0) {
            if (chars[left]==' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            } else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = replaceSpace("We are happy.");
        System.out.println(s);
    }

}