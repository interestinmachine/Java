package com.example.MyBatisDemo.mapper;

import com.example.MyBatisDemo.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {

    // 获取列表，根据 price 来正序或逆序
    public List<Goods> getOrderList(@Param("order")String order);
}
