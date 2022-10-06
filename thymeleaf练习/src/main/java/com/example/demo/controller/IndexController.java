package com.example.demo.controller;

import com.example.demo.v0.UserV0;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Date;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title","传递的Title");
        model.addAttribute("description","传递的description");
        model.addAttribute("keywords","传递的keywords");
        return "index";
    }

    @GetMapping("/basicTrain")
    public String basicTrain(Model model) {
        UserV0 userV0 = new UserV0();
        userV0.setUsername("lookroot");
        userV0.setAge(22);
        userV0.setVip(true);
        userV0.setCreateTime(new Date());
        userV0.setSex(1);
        userV0.setTags(Arrays.asList("PHP","JAVA","NodeJs"));
        model.addAttribute("user",userV0);
        return "basic";
    }
}
