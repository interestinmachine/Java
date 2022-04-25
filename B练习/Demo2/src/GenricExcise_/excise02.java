package GenricExcise_;

public class excise02 {
    public static void main(String[] args) {
        Apple<String,Integer,Double> apple = new Apple<>();
        apple.fly(10);//10 会被自动装箱 Integer10
        apple.fly(new Dog());
    }
}

class Apple<T,B,M> {
    public <E> void fly(E e) {
        System.out.println(e.getClass().getSimpleName());
    }

    //public void eat(U u){} //错误，因为U没有声明
    public void run(M m){}
}

class Dog{}

