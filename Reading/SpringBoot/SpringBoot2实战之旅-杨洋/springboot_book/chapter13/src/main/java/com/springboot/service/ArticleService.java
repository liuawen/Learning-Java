package com.springboot.service;

import com.springboot.entity.Article;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArticleService {

    List<Article> findIsTopArticleList();

    Page<Article> findBlogArticleList(int page, int size);

    Page<Article> findSearchArticleList(int page, int size,String keyword);

    Article findArticleByArticleId(Long articleId);

    Article findIsEnableArticleByArticleId(Long articleId);

    void saveArticle(Article article);
}
