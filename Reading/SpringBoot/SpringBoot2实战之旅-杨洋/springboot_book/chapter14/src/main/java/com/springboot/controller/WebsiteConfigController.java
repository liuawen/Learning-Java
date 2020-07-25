package com.springboot.controller;

import com.springboot.constants.Constants;
import com.springboot.entity.WebsiteConfig;
import com.springboot.service.WebsiteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/system")
public class WebsiteConfigController {

    @Autowired
    private WebsiteConfigService websiteConfigService;

    @GetMapping("/edit")
    public String system(Model model) {
        model.addAttribute("websiteConfig", websiteConfigService.findWebsiteConfig());
        model.addAttribute("menuFlag", Constants.SYSTEM_MENU_FLAG);
        return "system/edit";
    }

    @PostMapping("/saveOrUpdayeWebsiteConfig")
    @ResponseBody
    public void saveOrUpdayeWebsiteConfig(@RequestBody WebsiteConfig websiteConfig) {
        websiteConfigService.saveWebsiteConfig(websiteConfig);
    }
}
