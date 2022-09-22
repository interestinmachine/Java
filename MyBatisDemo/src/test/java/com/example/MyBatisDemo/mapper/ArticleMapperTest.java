package com.example.MyBatisDemo.mapper;

import com.example.MyBatisDemo.model.ArticleInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ArticleMapperTest {

    @Resource
    private ArticleMapper articleMapper;

    @Test
    void getAll() {
        ArticleInfo articleInfo = articleMapper.getAll(1);
        log.info("作者信息： " + articleInfo);
    }
}