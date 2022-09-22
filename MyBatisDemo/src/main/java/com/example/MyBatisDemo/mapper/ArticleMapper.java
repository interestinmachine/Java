package com.example.MyBatisDemo.mapper;

import com.example.MyBatisDemo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    public ArticleInfo getAll(@Param("id")Integer id);
}
