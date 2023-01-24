package com.example.mycnblog_ssm.mapper;

import com.example.mycnblog_ssm.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {

    // 得到我的博客列表
    public List<ArticleInfo> getMyList(@Param("uid")Integer uid);

    // 删除博客
    public int myDel(@Param("aid")Integer aid);

    // 得到文章详情
    public ArticleInfo getArtDetail(@Param("aid")Integer aid);

    // 修改文章
    public int update(@Param("aid") Integer aid,
                      @Param("uid") Integer uid,
                      @Param("title") String title,
                      @Param("content") String content);

    // 查询当前页码的数据
    public List<ArticleInfo> getList(@Param("offset")Integer offset, @Param("psize")Integer psize);

    // 计算总页数
    public int totalPage();

    public int postArticle(@Param("title")String title,@Param("content")String content,@Param("id")Integer id);
}
