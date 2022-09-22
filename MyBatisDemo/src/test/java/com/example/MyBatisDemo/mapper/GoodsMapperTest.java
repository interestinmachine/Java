package com.example.MyBatisDemo.mapper;

import com.example.MyBatisDemo.model.Goods;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class GoodsMapperTest {
    @Resource
    private GoodsMapper goodsMapper;

    @Test
    void getOrderList() {
        List<Goods> list = goodsMapper.getOrderList("asc");
        log.info("列表信息：" + list);
    }
}