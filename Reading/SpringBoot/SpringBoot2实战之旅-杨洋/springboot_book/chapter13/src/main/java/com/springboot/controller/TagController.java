package com.springboot.controller;

import com.springboot.entity.Tag;
import com.springboot.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public String tag(Model model) {
        model.addAttribute("tagList", tagService.findAll());
        return "tag";
    }

    @GetMapping("/tag/{tagName}")
    public String tag(Model model, @PathVariable String tagName) {
        Tag tag = tagService.findByTagName(tagName);
        model.addAttribute("tag", tag);
        model.addAttribute("articleList", tag.getArticleList());
        return "tagArticle";
    }
}
