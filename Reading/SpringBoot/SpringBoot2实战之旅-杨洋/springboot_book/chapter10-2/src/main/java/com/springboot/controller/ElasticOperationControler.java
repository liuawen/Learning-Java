package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class ElasticOperationControler {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("createIndex")
    public boolean createIndex(String indexName){
        return elasticsearchTemplate.createIndex(indexName);
    }

    @GetMapping("deleteIndex")
    public boolean deleteIndex(String indexName){
        return elasticsearchTemplate.deleteIndex(indexName);
    }

    @GetMapping("indexIsExist")
    public boolean indexIsExist(String indexName){
        return elasticsearchTemplate.indexExists(indexName);
    }

    @GetMapping("typeIsExist")
    public boolean typeIsExist(String indexName,String type){
        return elasticsearchTemplate.typeExists(indexName,type);
    }

    @GetMapping("getMapping")
    public Map getMapping(String indexName, String type){
        return elasticsearchTemplate.getMapping(indexName,type);
    }

    @GetMapping("getSetting")
    public Map getSetting(String indexName){
        return elasticsearchTemplate.getSetting(indexName);
    }
}
