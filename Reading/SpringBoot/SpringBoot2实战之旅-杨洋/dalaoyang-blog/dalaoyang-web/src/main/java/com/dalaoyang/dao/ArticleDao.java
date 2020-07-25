package com.dalaoyang.dao;

import com.dalaoyang.entity.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleDao {

    ArticleInfo getArticleInfoById(int id);

    void updateArticleReadingTime(int id);

    List<ArticleInfo> getArticleByPage(int pageNumber);

    int getArticleCount();

    List<ArticleInfo> getArticleListByTagNamePage(Map map);

    int getArticleByTagCount(String tagName);

    ArticleInfo viewArticleById(int id);

    List<ArticleInfo> getArticleListByWord(Map map);

    int getArticleListByWordCount(Map map);

    List<ArticleInfo> getCommonArticleList();

    List<ArticleInfo> getArticleListForSitemap();

    void modifyArticleImages(Map map);
}
