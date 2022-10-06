package com.example.springTransaction.Service;

import com.example.springTransaction.mapper.LogMapper;
import com.example.springTransaction.mapper.UserMapper;
import com.example.springTransaction.model.LogInfo;
import com.example.springTransaction.model.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private LogMapper logMapper;

    @Transactional(propagation = Propagation.NESTED)
    public int add(UserInfo userInfo) {
        int ret = userMapper.add(userInfo);

        // 不管用户信息是否添加成功，都使用日志记录下来
//        LogInfo logInfo = new LogInfo();
//        logInfo.setName("添加用户");
//        logInfo.setDesc("添加用户的结果：" + ret);
//        logMapper.addLog(logInfo);
        return ret;
    }
}
