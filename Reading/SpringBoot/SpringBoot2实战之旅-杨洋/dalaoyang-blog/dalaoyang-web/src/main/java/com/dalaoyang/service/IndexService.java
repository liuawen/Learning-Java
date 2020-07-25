package com.dalaoyang.service;

import com.dalaoyang.dao.ArticleDao;
import com.dalaoyang.entity.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IndexService {

    @Autowired
    private ArticleDao articleDao;

    @Cacheable(value = "index", key = "#page")
    public List<ArticleInfo> getArticleByPage(int page) {
        return articleDao.getArticleByPage(page);
    }

    @Cacheable(value = "indexCount")
    public int getArticleCount() {
        return articleDao.getArticleCount();
    }

}
