package com.dalaoyang.controller;

import com.dalaoyang.consts.Consts;
import com.dalaoyang.dao.ArticleDao;
import com.dalaoyang.dao.TagDao;
import com.dalaoyang.entity.ArticleInfo;
import com.dalaoyang.service.CommonService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/search")
    public String search(String word, Integer pageNumber, Model model) {
        //1.查询关键字为空，直接返回
        if (StringUtils.isBlank(word)) {
            return "search";
        }
        //2.封装查询参数
        Map paramMap = new HashMap(16);
        int page = 0;
        if (pageNumber != null) {
            page = (pageNumber - 1) * Consts.PAGE_SIZE;
        }
        //3.放入参数后查询列表
        paramMap.put("word", word);
        paramMap.put("page", page);
        //4.查询结果个数
        int totalCount = articleDao.getArticleListByWordCount(paramMap);
        //5.条件不符合，直接返回
        if (pageNumber != null && Math.ceil(totalCount / Consts.PAGE_COMPARE_NUMBER) - pageNumber < 0) {
            return "error";
        }
        List<ArticleInfo> articleList = articleDao.getArticleListByWord(paramMap);
        //6.查询文章标签
        commonService.getArticleListTag(articleList);
        //7.返回参数到前台
        model.addAttribute("articleList", articleList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("word", word);
        return "search";
    }

}
