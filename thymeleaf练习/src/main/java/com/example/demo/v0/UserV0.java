package com.example.demo.v0;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserV0 {
    private String username;
    private Integer age;
    private Integer sex;
    private boolean isVip;
    private Date createTime;
    private List<String> tags;
}
