package com.dalaoyang.controller;

import com.dalaoyang.consts.Consts;
import com.dalaoyang.dao.TagDao;
import com.dalaoyang.entity.TagInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TagController {

    @Autowired
    private TagDao tagDao;

    @GetMapping("/tagList")
    public String tagList(Model model, Integer pageNumber, String tagName) {
        this.getList(model, pageNumber, tagName);
        return "tagList";
    }

    @PostMapping("/deleteTag")
    @ResponseBody
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public String deleteLink(@RequestParam int tagId) {
        tagDao.deleteTag(tagId);
        tagDao.deleteAllArticleTag(tagId);
        return "success";
    }

    public Model getList(Model model, Integer pageNumber, String tagName) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        int page = (pageNumber - 1) * 10;
        Map map = new HashMap(Consts.HASHMAP_DEFAULT_CAPACITY);
        map.put("page", page);
        map.put("tagName", tagName);
        List<TagInfo> tagList = tagDao.getTagListPage(map);
        int totalCount = tagDao.getTagListCount(map);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("tagName", tagName);
        model.addAttribute("tagList", tagList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("urlPre", "tag");
        return model;
    }
}
