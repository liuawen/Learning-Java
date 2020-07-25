package com.dalaoyang.controller;

import com.dalaoyang.consts.Consts;
import com.dalaoyang.dao.ArticleDao;
import com.dalaoyang.dao.TagDao;
import com.dalaoyang.entity.ArticleInfo;
import com.dalaoyang.entity.TagInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    @Autowired
    ArticleDao articleDao;

    @Autowired
    TagDao tagDao;

    @GetMapping("/articleList")
    public String index(Model model, Integer pageNumber, Integer id, String title) {
        this.getList(model, pageNumber, id, title);
        return "articleList";
    }

    @GetMapping("/editArticle")
    public String editArticle(Model model, Integer id) {
        List<TagInfo> tagList = tagDao.getTagByArticleId(id);
        StringBuffer tagNameS = new StringBuffer();
        for (int i = 0; i < tagList.size(); i++) {
            tagNameS.append(tagList.get(i).getTagName());
            if (i != tagList.size() - 1) {
                tagNameS.append(",");
            }
        }
        model.addAttribute("tagNameS", tagNameS.toString());
        model.addAttribute("tagList", tagList);
        model.addAttribute("urlPre", "insertArticle");
        if (id != null) {
            ArticleInfo articleInfo = articleDao.getArticleInfoById(id);
            model.addAttribute("articleInfo", articleInfo);
            model.addAttribute("TITLE", "修改文章");
        } else {
            model.addAttribute("TITLE", "新增文章");
        }
        return "editArticle";
    }

    @PostMapping("/postEditArticle")
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public String postEditArticle(@RequestParam Integer articleId, @RequestParam String articleName,
                                  @RequestParam String articleAuthors, @RequestParam String articleIsTop,
                                  @RequestParam String[] tagNames, @RequestParam String articleContent) {
        Map map = new HashMap(Consts.HASHMAP_DEFAULT_CAPACITY);
        map.put("articleId", articleId);
        map.put("articleName", articleName);
        map.put("articleAuthors", articleAuthors);
        map.put("articleIsTop", articleIsTop);
        map.put("articleContent", articleContent);
        if (articleId == 0) {
            articleDao.saveArticle(map);
            articleId = articleDao.getLastId();
        } else {
            articleDao.editArticle(map);
            //删除之前文章的所有标签
            tagDao.deleteArticleTag(articleId);
        }

        for (int i = 0; i < tagNames.length; i++) {
            Map tagMap = new HashMap(Consts.HASHMAP_DEFAULT_CAPACITY);
            String tagName = tagNames[i].toUpperCase();
            Integer tagId = tagDao.getTagIdByName(tagName);
            if (tagId == null) {
                tagDao.saveTag(tagName);
                tagId = tagDao.getLastId();
            }
            tagMap.put("articleId", articleId);
            tagMap.put("tagId", tagId);
            tagDao.saveArticleTag(tagMap);
        }
        return "redirect:/articleList";
    }

    @PostMapping("/pulishArticle")
    @ResponseBody
    public String pulishArticle(@RequestParam int articleId) {
        articleDao.updateArticleRelease2Y(articleId);
        return "success";
    }

    @PostMapping("/cancleArticle")
    @ResponseBody
    public String cancleArticle(@RequestParam int articleId) {
        articleDao.updateArticleRelease2N(articleId);
        return "success";
    }


    public Model getList(Model model, Integer pageNumber, Integer id, String title) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        int page = (pageNumber - 1) * 10;
        Map map = new HashMap(Consts.HASHMAP_DEFAULT_CAPACITY);
        map.put("page", page);
        map.put("id", id);
        map.put("title", title);
        //文章列表
        List<ArticleInfo> articleList = articleDao.getArticleListPage(map);
        //文章总数
        int totalCount = articleDao.getArticleListCount(map);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("title", title);
        model.addAttribute("id", id);
        model.addAttribute("articleList", articleList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("urlPre", "article");
        return model;
    }
}
