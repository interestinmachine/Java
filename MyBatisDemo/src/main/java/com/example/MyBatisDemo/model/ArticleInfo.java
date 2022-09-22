package com.example.MyBatisDemo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private Integer uid;
    private Integer rcount;
    private Integer state;
    private UserInfo userInfo;

}
