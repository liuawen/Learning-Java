package com.springboot.controller;

import com.springboot.constants.Constants;
import com.springboot.entity.Article;
import com.springboot.entity.Pages;
import com.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public String article(Integer pageNumber, Long articleId, String articleName,
                          String articleAuthors, Model model) {
        Pages pages = Pages.defaultPages(pageNumber);
        Page<Article> articlePage = articleService.findAllBySearch(pages, articleId, articleName, articleAuthors);
        model.addAttribute("articleList", articlePage.getContent());
        model.addAttribute("totalCount", articlePage.getTotalElements());
        model.addAttribute("pageNumber", pages.getPageNumber());
        model.addAttribute("articleName", articleName);
        model.addAttribute("articleAuthors", articleAuthors);
        model.addAttribute("articleId", articleId);
        model.addAttribute("menuFlag", Constants.ARTICLE_MENU_FLAG);
        return "article/index";
    }

    @GetMapping("/saveOrUpdatePage")
    public String saveOrUpdateArticlePage(Model model, Long articleId) {
        Article article = new Article();
        if (articleId != null) {
            article = articleService.findArticleByArticleId(articleId);
        } else {
            article.setArticleId(0L);
        }
        model.addAttribute("article", article);
        model.addAttribute("menuFlag", Constants.ARTICLE_MENU_FLAG);
        return "article/edit";
    }

    @PostMapping("/updateArticleIsEnable")
    @ResponseBody
    public void updateArticleIsEnable(@RequestParam Long articleId, @RequestParam Integer isEnable) {
        articleService.updateArticleIsEnable(articleId, isEnable);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void deleteArticle(@RequestParam Long articleId) {
        articleService.deleteArticle(articleId);
    }

    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public String saveOrUpdateArticle(@RequestBody Article article) {
        articleService.saveOrUpdateArticle(article);
        return "success";
    }


}
