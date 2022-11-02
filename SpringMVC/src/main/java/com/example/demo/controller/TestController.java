package com.example.demo.controller;

import com.example.demo.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class TestController {
    @PostMapping
    public String save(UserInfo userInfo) {
        System.out.println("user save...");
        return "{'moudle': 'userinfo save'}";
    }

    @PutMapping
    public String update(UserInfo userInfo) {
        System.out.println("user update..." + userInfo);
        return "{'moudle': 'userinfo update'}";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("user delete..." + id);
        return "{'moudle': 'userinfo delete'}";
    }

}
