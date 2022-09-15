import model.userBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        //1.获取 spring 上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        //2.从 spring（上下文）中获取业务对象【2.1 通过 id 来获取 Bean 对象】
        //userBean user = (userBean) context.getBean("user");

        //2.从 spring（上下文）中获取业务对象【2.2 通过 对象类型class 来获取 Bean 对象】
        //userBean user = context.getBean(userBean.class);

        //2.从 spring（上下文）中获取业务对象【2.3 通过 id+对象类型class 来获取 Bean 对象】
        userBean user = context.getBean("user",userBean.class);

        //3.使用业务对象
        user.printName("我叼你🐎的");
    }
}

