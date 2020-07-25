package com.springboot.controller;

import com.springboot.constants.Constants;
import com.springboot.entity.Article;
import com.springboot.service.ArticleService;
import com.springboot.util.HtmlSpirit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class BlogController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/blog")
    public String blog(Model model) {
        return this.blog(model, 1);
    }

    @GetMapping("/blog/{pageNumber}")
    public String blog(Model model, @PathVariable Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        Page<Article> articlePage = articleService.findBlogArticleList((pageNumber-1)*Constants.defaultPageSize,Constants.defaultPageSize );
        List<Article> articleList = articlePage.getContent();
        articleList.forEach(article -> {
            String articleIntroduction = HtmlSpirit.delHTMLTag(article.getArticleContent());
            article.setArticleIntroduction(articleIntroduction.length() > 100 ? articleIntroduction.substring(0, 100) : articleIntroduction);
        });
        model.addAttribute("articleList", articleList);
        model.addAttribute("totalCount", articlePage.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        return "blog";
    }
}
