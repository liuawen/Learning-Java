package com.springboot.controller;

import com.springboot.constants.Constants;
import com.springboot.entity.WebsiteAccess;
import com.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private WebsiteAccessService websiteAccessService;

    @RequestMapping({"/", "/index"})

    public String index(Model model) {
        model.addAttribute("articleTotalCount", articleService.count());
        model.addAttribute("tagTotalCount", tagService.count());
        model.addAttribute("linkTotalCount", linkService.count());
        model.addAttribute("messageTotalCount", messageService.count());
        model.addAttribute("todayWebsiteVisit", websiteAccessService.sumWebsiteAccess(new Date(), null));
        model.addAttribute("weekWebsiteVisit", websiteAccessService.sumWebsiteAccess(new Date(), 7));
        model.addAttribute("monthWebsiteVisit", websiteAccessService.sumWebsiteAccess(new Date(), 30));
        model.addAttribute("totalWebsiteVisit", websiteAccessService.sumWebsiteAccess(null, null));
        List<WebsiteAccess> websiteAccessList = websiteAccessService.findChartsWebsiteAccess();
        List<Integer> websiteAccessCountList = websiteAccessList.stream().map(WebsiteAccess::getAccessCount).collect(Collectors.toList());
        List<Date> websiteAccessDateList = websiteAccessList.stream().map(WebsiteAccess::getAccessDate).collect(Collectors.toList());
        model.addAttribute("websiteAccessCountList", websiteAccessCountList);
        model.addAttribute("websiteAccessDateList", websiteAccessDateList);
        model.addAttribute("menuFlag", Constants.INDEX_MENU_FLAG);
        return "index";
    }

}
