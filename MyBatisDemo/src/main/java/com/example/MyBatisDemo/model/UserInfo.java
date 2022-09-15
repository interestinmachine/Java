package com.example.MyBatisDemo.model;

import lombok.Data;

/**
 * 普通实体类
 */
@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private int state;

}
