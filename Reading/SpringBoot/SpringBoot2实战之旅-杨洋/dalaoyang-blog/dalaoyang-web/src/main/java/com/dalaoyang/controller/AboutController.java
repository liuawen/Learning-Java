package com.dalaoyang.controller;

import com.dalaoyang.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

    @Autowired
    private ArticleDao articleDao;

    @RequestMapping(value = "/about")
    public String about(Model model) {
        //1.将about页面内容返回前台
        model.addAttribute("articleInfo", articleDao.viewArticleById(85));
        return "about";
    }
}
