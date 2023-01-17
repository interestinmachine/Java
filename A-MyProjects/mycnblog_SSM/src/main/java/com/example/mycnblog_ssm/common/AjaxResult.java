package com.example.mycnblog_ssm.common;

import java.util.HashMap;

/**
 * 自定义统一返回对象
 */
public class AjaxResult {

    /**
     * 业务执行成功时，返回的方法
     * @param data
     * @return
     */
    public static HashMap<String, Object> success(Object data) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","");
        map.put("data",data);

        return map;
    }

    /**
     * 业务执行成功时，返回的方法
     * @param data
     * @return
     */
    public static HashMap<String, Object> success(String message,Object data) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg",message);
        map.put("data",data);

        return map;
    }

    /**
     * 业务执行成功时，返回的方法
     * @param data
     * @return
     */
    public static HashMap<String, Object> success(Integer code,String message,Object data) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",message);
        map.put("data",data);

        return map;
    }

    /**
     * 业务执行失败时，返回的方法
     * @param data
     * @return
     */
    public static HashMap<String, Object> fail(Integer code,String message,Object data) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",message);
        map.put("data",data);

        return map;
    }
}
