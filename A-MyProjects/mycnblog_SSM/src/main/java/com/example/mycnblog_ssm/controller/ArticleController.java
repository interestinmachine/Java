package com.example.mycnblog_ssm.controller;

import com.example.mycnblog_ssm.common.AjaxResult;
import com.example.mycnblog_ssm.common.Constant;
import com.example.mycnblog_ssm.common.SessionUtil;
import com.example.mycnblog_ssm.model.ArticleInfo;
import com.example.mycnblog_ssm.model.UserInfo;
import com.example.mycnblog_ssm.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 文章控制器
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/mylist")
    public List<ArticleInfo> myList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            UserInfo userInfo = (UserInfo) session.getAttribute(Constant.SESSION_USERINFO_KEY);
            return articleService.getMyList(userInfo.getId());
        }
        return null;
    }

    @RequestMapping("/mydel")
    public int myDel(Integer aid) {
        return articleService.myDel(aid);
    }

    @RequestMapping("/detail")
    public Object getArtDetail(Integer aid) {
        if (aid != null && aid > 0) {
            return AjaxResult.success(articleService.getArtDetail(aid));
        }
        return AjaxResult.fail(-1, "查询失败",0);
    }

    @RequestMapping("/detailbyid")
    public Object detailById(HttpServletRequest request,Integer aid) {
        if (aid != null && aid > 0) {
            // 根据文章查询文章的详情
            ArticleInfo articleInfo = articleService.getArtDetail(aid);
            // 文章的归属人验证
            UserInfo userInfo = SessionUtil.getLoginUser(request);
            if (userInfo != null && articleInfo != null &&
                    userInfo.getId() == articleInfo.getUid()) { // 文章归属人是正确的
                return AjaxResult.success(articleInfo);
            }
        }
        return AjaxResult.fail(-1, "查询失败",0);
    }

    @RequestMapping("/update")
    public int update(HttpServletRequest request, Integer aid, String title, String content) {
        // todo:非空效验
        UserInfo userInfo = SessionUtil.getLoginUser(request);
        if (userInfo != null && userInfo.getId() > 0) {
            return articleService.update(aid, userInfo.getId(), title, content);
        }
        return 0;
    }

    /**
     * 查询分页数据
     * @param pindex
     * @param psize
     * @return
     */
    @RequestMapping("/list")
    public List<ArticleInfo> getList(Integer pindex,Integer psize) {
        if (pindex == null || psize == null) {
            return null;
        }
        // 计算偏移量
        Integer offset = (pindex - 1) * psize;
        return articleService.getList(offset,psize);
    }

    /**
     * 计算总页数
     * @return
     */
    @RequestMapping("/totalpage")
    public Integer totalPage(Integer psize) {
        if (psize != null) {
            int totalCount = articleService.totalPage();
            int totalPage = (int) Math.ceil(totalCount*1.0/psize);

            return totalPage;
        }
        return null;
    }

    @RequestMapping("/postarticle")
    public Object postArticle(HttpServletRequest request,String title,String content) {
        System.out.println("=====================================");
        System.out.println("content的内容为：" + content);
        System.out.println("title的内容为：" + title);
        System.out.println("=====================================");
        UserInfo userInfo = SessionUtil.getLoginUser(request);
        if (userInfo != null) {
            return articleService.postArticle(title,content,userInfo.getId());
        }
        return AjaxResult.fail(-1,"发布博客失败",0);
    }
}
