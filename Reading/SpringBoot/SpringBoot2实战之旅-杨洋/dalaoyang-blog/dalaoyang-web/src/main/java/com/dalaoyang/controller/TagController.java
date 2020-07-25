package com.dalaoyang.controller;

import com.dalaoyang.consts.Consts;
import com.dalaoyang.entity.ArticleInfo;
import com.dalaoyang.service.CommonService;
import com.dalaoyang.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/{tagName}")
    public String getArticleListByTagName(Model model, @PathVariable String tagName) {
        return this.getList(model, tagName, 1);
    }


    @RequestMapping(value = "/{tagName}/{pageNumber}")
    public String getArticleListByTagNamePage(Model model, @PathVariable String tagName,
                                              @PathVariable Integer pageNumber) {
        StringBuffer sb = new StringBuffer();
        sb.append(Consts.TAG_BASE_URL);
        sb.append(tagName);
        sb.append(Consts.BASE_URL);
        if (pageNumber == 1) {
            return sb.toString();
        }
        return this.getList(model, tagName, pageNumber);
    }


    public String getList(Model model, String tagName, Integer pageNumber) {
        //1.封装参数，查询文章列表个数
        Map map = new HashMap(8);
        map.put("tagName", tagName);
        map.put("page", (pageNumber - 1) * Consts.PAGE_SIZE);
        List<ArticleInfo> articleList = tagService.getArticleListByTagNamePage(map, tagName + (pageNumber - 1) * Consts.PAGE_SIZE);
        //2.查询标签
        commonService.getArticleListTag(articleList);
        //3.查询文章个数
        int totalCount = tagService.getArticleByTagCount(tagName);
        //4.返回前台数据
        model.addAttribute("articleList", articleList);
        model.addAttribute("tagName", tagName);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("urlPre", "tag/" + tagName + "/");
        //5.根据情况返回页面
        if (Math.ceil(totalCount / Consts.PAGE_COMPARE_NUMBER) - pageNumber < 0) {
            return "error";
        } else {
            return "blog";
        }
    }

}
