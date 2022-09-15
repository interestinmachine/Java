package com.example.springboot.zzy;

import com.example.springboot.zzy.model.ReadList;
import com.example.springboot.zzy.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Value("${server.port}") // 读取 application.properties 文件中的配置项
    private int port;

    @Autowired
    private Student student1;

    @Autowired
    private ReadList readList;


    @ResponseBody // 返回一个非静态页面的数据，如不加这个，浏览器则会寻找名为“Hello, World."的页面，而不会返回“Hello, World."的数据
    @RequestMapping("/sayhi") // 设置路由地址，地址名称一定要小写，因为Windows不严格区分大小写，而Linux严格区分，为了防止在两个系统
                                // 上程序运行结果一致，需要使用小写名称。
    public String sayHi() {
        return "ReadList: " + readList.name;
    }

}
