package com.springboot.controller;

import com.springboot.entity.Book;
import com.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/test1")
    public String test1(){
        bookRepository.save(new Book("JAVA从入门到精通"));
        bookRepository.save(new Book("SpringBoot2实战之旅"));
        return "success";
    }

    @GetMapping("/test2")
    @Transactional
    public String test2(){
        bookRepository.save(new Book("JAVA从入门到精通"));
        bookRepository.save(new Book("SpringBoot2实战之旅"));
        return "success";
    }
}
