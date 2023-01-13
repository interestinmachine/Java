import com.example.config.SpringConfig;
import com.example.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class test {

    @Autowired
    private IAccountService as = null;

    @Autowired
    private ApplicationContext ac =null;

    @Test
    public void test() {
        ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 2. 根据id获取Bean对象
        as = (IAccountService) ac.getBean("accountService");

        as.saveAccount();
    }
}
