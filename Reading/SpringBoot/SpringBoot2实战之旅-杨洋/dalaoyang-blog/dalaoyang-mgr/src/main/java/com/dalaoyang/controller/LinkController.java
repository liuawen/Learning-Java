package com.dalaoyang.controller;

import com.dalaoyang.consts.Consts;
import com.dalaoyang.dao.LinkDao;
import com.dalaoyang.entity.LinkInfo;
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
public class LinkController {

    @Autowired
    private LinkDao linkDao;

    @GetMapping("/linkList")
    public String linkList(Model model, Integer pageNumber, String linkName) {
        this.getList(model, pageNumber, linkName);
        return "linkList";
    }

    @GetMapping("/editLink")
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public String editLink(Model model, Integer id) {
        model.addAttribute("TITLE", "新增友链");
        if (id != null) {
            LinkInfo linkInfo = linkDao.getLinkInfoById(id);
            model.addAttribute("linkInfo", linkInfo);
            model.addAttribute("TITLE", "修改友链");
        }
        model.addAttribute("urlPre", "link");
        return "editLink";
    }

    @PostMapping("/postEditLink")
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public String postEditLink(@RequestParam Integer linkId, @RequestParam String linkName,
                               @RequestParam String linkUrl, @RequestParam String remark) {
        Map map = new HashMap(Consts.HASHMAP_DEFAULT_CAPACITY);
        map.put("linkId", linkId);
        map.put("linkName", linkName);
        map.put("linkUrl", linkUrl);
        map.put("remark", remark);
        if (linkId == 0) {
            linkDao.saveLink(map);
        } else {
            linkDao.editLink(map);
        }
        return "redirect:/linkList";
    }

    @PostMapping("/deleteLink")
    @ResponseBody
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public String deleteLink(@RequestParam int linkId) {
        linkDao.deleteLink(linkId);
        return "success";
    }

    public Model getList(Model model, Integer pageNumber, String linkName) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        int page = (pageNumber - 1) * 10;
        Map map = new HashMap(Consts.HASHMAP_DEFAULT_CAPACITY);
        map.put("page", page);
        map.put("linkName", linkName);
        List<LinkInfo> linkList = linkDao.getLinkListPage(map);
        int totalCount = linkDao.getLinkListCount(map);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("linkName", linkName);
        model.addAttribute("linkList", linkList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("urlPre", "link");
        return model;
    }
}
