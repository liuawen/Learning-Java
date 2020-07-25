package com.springboot.controller;

import com.springboot.entity.Article;
import com.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/view/{id}")
    public String viewArticle(Model model, @PathVariable Long id) {
        Article articleInfo = articleService.findArticleByArticleId(id);
        model.addAttribute("articleInfo", articleInfo);
        return "article";
    }
}
