package com.example.springTransaction.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private String photo;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private Integer state;
}
