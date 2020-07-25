package com.dalaoyang.controller;

import com.dalaoyang.consts.Consts;
import com.dalaoyang.entity.ArticleInfo;
import com.dalaoyang.service.CommonService;
import com.dalaoyang.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {
        return this.getList(model, 1);
    }

    @RequestMapping(value = "/{pageNumber}")
    public String getArticleListByPage(Model model, @PathVariable Integer pageNumber) {
        return this.getList(model, pageNumber);
    }

    public String getList(Model model, Integer pageNumber) {
        //1.计算页码
        int page = (pageNumber - 1) * Consts.PAGE_SIZE;
        //2.查询文章列表
        List<ArticleInfo> articleList = indexService.getArticleByPage(page);
        //3.查询文章个数
        int totalCount = indexService.getArticleCount();
        //4.查询文章标签
        commonService.getArticleListTag(articleList);
        //5.将数据返回前台
        model.addAttribute("articleList", articleList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("urlPre", "");
        //6.判断当前页码是否正确
        if (Math.ceil(totalCount / Consts.PAGE_COMPARE_NUMBER) - pageNumber < 0) {
            return "error";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/googlea8ca16f98839d188.html")
    public String google() {
        return "googlea8ca16f98839d188";
    }
}
