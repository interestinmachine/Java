package com.example.mycnblog_ssm.common;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.sql.ResultSet;
import java.util.HashMap;

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof HashMap) {
            return body;
        }

        if (body instanceof String) { // 返回的类型是 String，需要进行处理，否则报错
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(AjaxResult.success(201,"String",body));
        }

        return AjaxResult.success(body);
    }
}
