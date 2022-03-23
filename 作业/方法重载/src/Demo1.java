class Methods {
    public int m(int num){
        return (int) Math.pow(num,2);
    }

    public int m(int num1,int num2){
        return (int)Math.pow(num1,num2);
    }

    public void m(String s){
        System.out.println(s);
    }

}

public class Demo1 {
    public static void main(String[] args) {
        System.out.println(new Methods().m(2));
        System.out.println(new Methods().m(3,2));
        Methods methods = new Methods();
        methods.m("aaaa");
    }
}

