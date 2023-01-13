package com.example.demo.service;

import com.example.demo.mapper.LogMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.LogInfo;
import com.example.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class LogService {

    @Autowired
    private LogMapper logMapper;

    @Transactional(propagation = Propagation.NESTED)
    public int addLog(String content) {
        // 出现异常
        try {
            int i = 10/0;
        } catch (Exception e) {
            System.out.println("addLog 要回滚了！");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return logMapper.addLog(content);
    }
}











