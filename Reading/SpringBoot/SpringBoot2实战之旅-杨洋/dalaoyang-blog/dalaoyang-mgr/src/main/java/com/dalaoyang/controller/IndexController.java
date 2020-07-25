package com.dalaoyang.controller;

import com.dalaoyang.dao.*;
import com.dalaoyang.entity.ArticleInfo;
import com.dalaoyang.entity.UserInfo;
import com.dalaoyang.entity.WebsiteAccessInfo;
import com.dalaoyang.entity.WebsiteSystemInfo;
import com.dalaoyang.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class IndexController {
    @Autowired
    ArticleDao articleDao;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private LinkDao linkDao;

    @Autowired
    private WebsiteSystemInfoDao websiteSystemInfoDao;

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private WebsiteAccessInfoDao websiteAccessInfoDao;

    @GetMapping("/")
    public String index(Model model) {
        int articleCount = articleDao.getArticleListCount(null);
        int tagCount = tagDao.getTagListCount(null);
        int linkCount = linkDao.getLinkListCount(null);
        List<ArticleInfo> articleList = articleDao.getReleaseArticleTop();
        List<UserInfo> userList = loginDao.getUserList();

        //访问人数
        WebsiteSystemInfo websiteSystemInfo = websiteSystemInfoDao.getWebsiteSystemInfo();
        //最近七天访问人数
        List<WebsiteAccessInfo> websiteAccessInfoList = websiteAccessInfoDao.getThisWeekWebsiteAccessInfo();
        this.formatAccessDate(websiteAccessInfoList);
        model.addAttribute("websiteAccessInfoList", websiteAccessInfoList);
        model.addAttribute("userList", userList);
        model.addAttribute("articleList", articleList);
        model.addAttribute("websiteSystemInfo", websiteSystemInfo);
        model.addAttribute("linkCount", linkCount);
        model.addAttribute("tagCount", tagCount);
        model.addAttribute("articleCount", articleCount);
        model.addAttribute("urlPre", "index");
        return "index";
    }


    private void formatAccessDate(List<WebsiteAccessInfo> websiteAccessInfoList){
        Collections.sort(websiteAccessInfoList, (o1, o2)
                -> (o1.getAccessDate().compareTo(o2.getAccessDate()))
        );
        websiteAccessInfoList.forEach(p -> {
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("MM-dd");
            p.setAccessDateStr(simpleDateFormat.format(p.getAccessDate()));
        });
    }

}
