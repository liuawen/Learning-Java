package com.dalaoyang.service;

import com.dalaoyang.dao.ArticleDao;
import com.dalaoyang.entity.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TagService {

    @Autowired
    private ArticleDao articleDao;

    @Cacheable(value = "tagname", key = "#tagName")
    public List<ArticleInfo> getArticleListByTagNamePage(Map map, String tagName) {
        return articleDao.getArticleListByTagNamePage(map);
    }

    @Cacheable(value = "tagCount", key = "#tagName")
    public int getArticleByTagCount(String tagName) {
        return articleDao.getArticleByTagCount(tagName);
    }
}
