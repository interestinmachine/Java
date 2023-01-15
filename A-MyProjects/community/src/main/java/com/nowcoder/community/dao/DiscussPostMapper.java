package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    /**
     * 分页查询，显示前10个帖子
     * @param userId
     * @param offset 每页的起始行号
     * @param limit  每页能存多少帖子
     * @return
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @Param 注解用于给参数起别名
    // 如果只有一个参数，并且在 <if> 里使用，则必须加别名
    Integer selectDiscussPostRows(@Param("userId") int userId);
}
