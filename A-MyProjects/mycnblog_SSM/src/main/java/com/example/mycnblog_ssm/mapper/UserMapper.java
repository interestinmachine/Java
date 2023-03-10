package com.example.mycnblog_ssm.mapper;

import com.example.mycnblog_ssm.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public int addUser(@Param("username") String username, @Param("password") String password);

    public UserInfo login (@Param("username") String username, @Param("password") String password);

    public UserInfo myInfoByUid(@Param("uid")Integer uid);

    public UserInfo getUserByName(@Param("username")String username);

}
