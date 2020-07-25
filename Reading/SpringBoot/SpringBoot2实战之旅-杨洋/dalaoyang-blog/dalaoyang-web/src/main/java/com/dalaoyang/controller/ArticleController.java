package com.dalaoyang.controller;

import com.dalaoyang.dao.ArticleDao;
import com.dalaoyang.entity.ArticleInfo;
import com.dalaoyang.service.CommonService;
import com.dalaoyang.util.MarkdownToHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CommonService commonService;

    @GetMapping(value = "/article/{id}")
    public String articleInfo(Model model, @PathVariable int id) {
        //1.更改文章阅读次数
        articleDao.updateArticleReadingTime(id);
        ArticleInfo articleInfo = articleDao.getArticleInfoById(id);
        //2.文章格式转换
        articleInfo.setArticleContent(MarkdownToHtml.markDownToHtml(articleInfo.getArticleContent()));
        //3.文章标签查询
        articleInfo.setTagInfoList(commonService.getTagByArticleId(articleInfo.getArticleId()));
        //4.将封装好的ArticleInfo返回前台
        model.addAttribute("articleInfo", articleInfo);
        return "article";
    }
}
