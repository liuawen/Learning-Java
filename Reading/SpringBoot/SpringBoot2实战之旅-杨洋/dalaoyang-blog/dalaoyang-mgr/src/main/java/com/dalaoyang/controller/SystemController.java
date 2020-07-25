package com.dalaoyang.controller;

import com.dalaoyang.dao.WebsiteSystemPropertyDao;
import com.dalaoyang.entity.WebsiteSystemProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private WebsiteSystemPropertyDao websiteSystemPropertyDao;

    @GetMapping("/")
    public String getSystemProperty(Model model) {
        WebsiteSystemProperty websiteSystemProperty = websiteSystemPropertyDao.getWebsiteSystemProperty();
        model.addAttribute("websiteSystemProperty", websiteSystemProperty);
        model.addAttribute("urlPre", "system");
        return "system";
    }

    @PostMapping("/updateSystemProperty")
    public String updateSystemProperty(WebsiteSystemProperty websiteSystemProperty) {
        websiteSystemPropertyDao.updateSystemProperty(websiteSystemProperty);
        return "redirect:/";
    }
}
