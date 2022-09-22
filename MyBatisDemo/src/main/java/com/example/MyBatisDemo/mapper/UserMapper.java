package com.example.MyBatisDemo.mapper;

import com.example.MyBatisDemo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper // 变成 mybatis interface
public interface UserMapper {
    // 根据用户 id 查询用户
    public UserInfo getUserById(@Param("id")Integer id); // @Param 代表参数在xml中名字为 id

    // 根据用户 id 更新，返回更新的行数
    public int update(@Param("id")Integer id, @Param("username")String username);

    // 根据 id 来删除用户，返回删除的行数
    public int del(@Param("id")Integer id);

    // 添加用户，返回受影响的行数
    public int add(UserInfo userInfo);

    // 添加用户，返回新增用户的id
    public int addGetId(UserInfo userInfo);

    // 根据用户名字查询信息
    public UserInfo getUserByName(@Param("name")String username);

    public List<UserInfo> getUserByName2(@Param("username")String username);

    // 登录功能
    public List<UserInfo> login(@Param("username")String username, @Param("password")String password);

    // 添加用户，photo 是非必传参数
    public int add2(UserInfo userInfo);

    // 根据用户 id 查询用户信息，和 所对应的文章信息
    public UserInfo getUserAndArticleById(@Param("id")Integer id);

    // 添加用户，其中 username、password、photo 都是非必传参数
    // 但至少会传递一个参数
    public int add3(UserInfo userInfo);

    public int updateById(UserInfo userInfo);

    public int delIds(List<Integer> ids);
}
