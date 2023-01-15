package com.example.mycnblog_ssm.model;

import lombok.Data;

@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    private String createtime;
    private String updatetime;
    private Integer uid; // 文章对应作者的id
    private Integer rcount; // 文章的阅读量
    private Integer state;
}
