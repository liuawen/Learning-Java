package com.dalaoyang.dao;

import com.dalaoyang.entity.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleDao {

    List<ArticleInfo> getArticleListPage(Map map);

    int getArticleListCount(Map map);

    void updateArticleRelease2Y(int id);

    void updateArticleRelease2N(int id);

    void saveArticle(Map map);

    int getLastId();

    ArticleInfo getArticleInfoById(int id);

    void editArticle(Map map);

    List<ArticleInfo> getReleaseArticleTop();


}
