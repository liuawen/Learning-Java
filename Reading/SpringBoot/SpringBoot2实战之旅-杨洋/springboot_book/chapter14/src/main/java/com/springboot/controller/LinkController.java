package com.springboot.controller;

import com.springboot.constants.Constants;
import com.springboot.entity.Link;
import com.springboot.entity.Pages;
import com.springboot.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/list")
    public String link(Integer pageNumber, Long linkId, String linkName, Model model) {
        Page<Link> linkPage = linkService.findAllBySearch(Pages.defaultPages(pageNumber), linkId, linkName);
        model.addAttribute("linkList", linkPage.getContent());
        model.addAttribute("totalCount", linkPage.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("linkId", linkId);
        model.addAttribute("linkName", linkName);
        model.addAttribute("menuFlag", Constants.LINK_MENU_FLAG);
        return "link/index";
    }

    @GetMapping("/saveOrUpdatePage")
    public String saveOrUpdateLinkPage(Long linkId, Model model) {
        Link link = new Link();
        if (linkId != null) {
            link = linkService.findLinkByLinkId(linkId);
        } else {
            link.setLinkId(0L);
        }
        model.addAttribute("link", link);
        model.addAttribute("menuFlag", Constants.LINK_MENU_FLAG);
        return "link/edit";
    }

    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public void saveOrUpdateLink(@RequestBody Link link) {
        linkService.saveOrUpdateLink(link);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void deleteLink(Long linkId) {
        linkService.deleteLink(linkId);
    }
}
