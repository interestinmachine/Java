package annotation;

public class Deprecated {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.n1);
        a.hi();
    }
}

//1. @Deprecated 修饰某个元素，表示该元素已经过时了
//2. 即不再推荐使用，但是仍然可以使用
//3. 查看 @Deprecated 注解类的源码
//4. 可以修饰方法，类、字段、包、参数等
//5. @Deprecated 可以做版本升级过渡使用
/*
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Deprecated {
}
 */
@java.lang.Deprecated
class A {
    public int n1 = 10;
    public void hi(){
    }
}
