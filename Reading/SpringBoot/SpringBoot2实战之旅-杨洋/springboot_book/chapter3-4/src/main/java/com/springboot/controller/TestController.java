package com.springboot.controller;

import com.springboot.entity.BookConfigBean;
import com.springboot.entity.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    @Autowired
    private BookConfigBean bookConfigBean;

    @Autowired
    private ConfigBean configBean;

    @Value("${book.name}")
    private String bookName;

    @Value("${book.author}")
    private String bookAuthor;

    @GetMapping("test1")
    public String test1(){
        return "本书书名是：" + bookName + ",作者是：" + bookAuthor;
    }

    @GetMapping("test2")
    public BookConfigBean test2(){
        return bookConfigBean;
    }

    @GetMapping("test3")
    public ConfigBean test3(){
        return configBean;
    }
}
