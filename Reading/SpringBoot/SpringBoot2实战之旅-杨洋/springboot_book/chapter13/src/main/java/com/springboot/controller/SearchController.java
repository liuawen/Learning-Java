package com.springboot.controller;

import com.springboot.constants.Constants;
import com.springboot.entity.Article;
import com.springboot.service.ArticleService;
import com.springboot.util.HtmlSpirit;
import org.parboiled.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/search")
    public String search(Model model, Integer pageNumber, String keyword) {
        if (StringUtils.isEmpty(keyword)) {
            return "search";
        } else if (pageNumber == null) {
            pageNumber = 1;
        }
        Page<Article> articlePage = articleService.findSearchArticleList((pageNumber - 1) * Constants.defaultPageSize, Constants.defaultPageSize, keyword);
        List<Article> articleList = articlePage.getContent();
        articleList.forEach(article -> {
            String articleIntroduction = HtmlSpirit.delHTMLTag(article.getArticleContent());
            article.setArticleIntroduction(articleIntroduction.length() > 100 ? articleIntroduction.substring(0, 100) : articleIntroduction);
        });
        model.addAttribute("articleList", articleList);
        model.addAttribute("totalCount", articlePage.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("keyword", keyword);
        return "search";
    }


}
