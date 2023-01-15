package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiscussPostMapperTest {

    @Resource
    DiscussPostMapper discussPostMapper;

    @Test
    void selectDiscussPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(2,0,2);
        for(DiscussPost post:list) {
            System.out.println(post);
        }
    }

    @Test
    void selectDiscussPostRows() {
        Integer row = discussPostMapper.selectDiscussPostRows(2);
        System.out.println(row);
    }
}