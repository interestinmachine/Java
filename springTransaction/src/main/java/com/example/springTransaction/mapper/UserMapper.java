package com.example.springTransaction.mapper;

import com.example.springTransaction.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public int add(UserInfo userInfo);
}
