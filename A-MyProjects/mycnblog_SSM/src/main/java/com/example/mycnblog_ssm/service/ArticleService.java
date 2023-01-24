package com.example.mycnblog_ssm.service;

import com.example.mycnblog_ssm.mapper.ArticleMapper;
import com.example.mycnblog_ssm.model.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章服务层
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<ArticleInfo> getMyList(Integer uid) {
        return articleMapper.getMyList(uid);
    }

    public int myDel(Integer aid) {
        return articleMapper.myDel(aid);
    }

    public ArticleInfo getArtDetail(Integer aid) {
        return articleMapper.getArtDetail(aid);
    }

    public int update(Integer aid, Integer uid, String title, String content) {
        return articleMapper.update(aid, uid, title, content);
    }

    public List<ArticleInfo> getList(Integer offset, Integer psize) {
        return articleMapper.getList(offset,psize);
    }

    public int totalPage() {
        return articleMapper.totalPage();
    }

    public int postArticle(String title,String content,Integer id) {
        return articleMapper.postArticle(title,content,id);
    }
}
