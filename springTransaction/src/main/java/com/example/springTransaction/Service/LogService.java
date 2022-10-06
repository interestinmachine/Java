package com.example.springTransaction.Service;

import com.example.springTransaction.mapper.LogMapper;
import com.example.springTransaction.model.LogInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

@Service
public class LogService {
    @Resource
    private LogMapper logMapper;

    @Transactional(propagation = Propagation.NESTED)
    public int saveLog(LogInfo logInfo) {
        int result = logMapper.addLog(logInfo);
        try {
            int num = 10 /0;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }
}
