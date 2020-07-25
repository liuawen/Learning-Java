package com.springboot.controller;

import com.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = {"/", "index"})
    public String index(Model model) {
        model.addAttribute("articleList", articleService.findIsTopArticleList());
        return "index";
    }
}
