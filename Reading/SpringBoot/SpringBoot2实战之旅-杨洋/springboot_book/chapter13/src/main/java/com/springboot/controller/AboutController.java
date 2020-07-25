package com.springboot.controller;

import com.springboot.entity.WebsiteConfig;
import com.springboot.service.ArticleService;
import com.springboot.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private WebsiteConfigService websiteConfigService;

    @GetMapping("/about")
    public String about(Model model){
        WebsiteConfig websiteConfig = websiteConfigService.findWebsiteConfig();
        model.addAttribute("article", articleService.findArticleByArticleId(websiteConfig.getAboutPageArticleId()));
        return "about";
    }
}
