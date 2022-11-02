package com.example.springboot.zzy.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "student1")
@Component
public class Student {
    private String name;
    private int age;
    private String sex;
}
