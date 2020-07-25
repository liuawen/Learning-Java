package com.springboot.controller;

import com.springboot.entity.Article;
import com.springboot.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BaseOperationController {

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("saveOrUpdate")
    public String saveOrUpdate(@RequestBody Article article){
        if(article.getId()==null){
            article.setId(System.currentTimeMillis());
        }
        articleRepository.save(article);
        return "保存成功";
    }

    @GetMapping("delete")
    public String delete(Long id){
        articleRepository.deleteById(id);
        return "删除成功";
    }

    @GetMapping("findById")
    public Article findById(long id){
        Article article = articleRepository.findById(id).get();
        return article;
    }

    @GetMapping("findAll")
    public Iterable<Article> findAll(){
        return articleRepository.findAll();
    }

}
