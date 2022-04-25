package homework;

import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        String name;
        String passwd;
        String email;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入用户名、密码、邮箱：");
        name = scanner.next();
        passwd = scanner.next();
        email = scanner.next();
        try {
            isLegal(name,passwd,email);
            System.out.println("录入信息正确");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void isLegal(String name,String passwd,String email){
        if (!(name.length() >= 2 && name.length() <= 4)){
            throw new RuntimeException("用户名长度不对，应为2-4位长度");
        }

        if (!(passwd.length() == 6 && isDigital(passwd))){
            throw new RuntimeException("密码长度必须为6，且全为数字");
        }

        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && i < j)){
            throw new RuntimeException("邮箱中包含@和. ，并且@在.的前面");
        }
    }

    public static boolean isDigital(String str){
        char[] chars = str.toCharArray();
        for(char e : chars){
            if (!(e >= '0' && e <= '9')){
                return false;
            }
        }

        return true;
    }
}



