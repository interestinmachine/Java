package com.example.springTransaction.model;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogInfo {
    private Integer id;
    private String name;
    private String desc;
    private LocalDateTime createtime;
}
