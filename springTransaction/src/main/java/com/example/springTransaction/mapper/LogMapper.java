package com.example.springTransaction.mapper;

import com.example.springTransaction.model.LogInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {

    public int addLog(LogInfo logInfo);
}
