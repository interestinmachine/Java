package com.example.index_saerch.controller;

import com.example.index_saerch.search.DocSearcher;
import com.example.index_saerch.search.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearcherController {

    public DocSearcher docSearcher = new DocSearcher();
    public ObjectMapper objectMapper = new ObjectMapper();

    // produces 设置服务器返回数据的格式
    @RequestMapping(value = "/searcher",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String search(@RequestParam("query") String query) throws JsonProcessingException {
        List<Result> resultList = docSearcher.search(query);
        return objectMapper.writeValueAsString(resultList);
    }
}
