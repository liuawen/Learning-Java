package com.dalaoyang.controller;

import com.dalaoyang.dao.ArticleDao;
import com.dalaoyang.entity.ArticleInfo;
import com.dalaoyang.service.CommonService;
import com.dalaoyang.util.MarkdownToHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/view")
public class ViewController {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CommonService commonService;

    @GetMapping("/{id}")
    public String viewArticle(Model model, @PathVariable int id) {
        //1.文章格式转换
        ArticleInfo articleInfo = articleDao.viewArticleById(id);
        articleInfo.setArticleContent(MarkdownToHtml.markDownToHtml(articleInfo.getArticleContent()));
        //2.文章标签查询
        articleInfo.setTagInfoList(commonService.getTagByArticleId(articleInfo.getArticleId()));
        //3.将封装好的ArticleInfo返回前台
        model.addAttribute("articleInfo", articleInfo);
        return "article";
    }

}
