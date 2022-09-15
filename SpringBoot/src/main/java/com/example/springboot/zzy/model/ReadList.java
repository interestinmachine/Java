package com.example.springboot.zzy.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties("dbtypes2")
public class ReadList {
    public List<String> name;
}
