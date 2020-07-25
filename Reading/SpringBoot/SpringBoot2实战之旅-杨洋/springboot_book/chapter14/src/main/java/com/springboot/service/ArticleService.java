package com.springboot.service;

import com.springboot.entity.Article;
import com.springboot.entity.Pages;
import org.springframework.data.domain.Page;

import java.util.Date;

public interface ArticleService {

    Page<Article> findAllBySearch(Pages pages, Long articleId, String articleName, String articleAuthors);

    Article findArticleByArticleId(Long articleId);

    void saveOrUpdateArticle(Article article);

    void updateArticleIsEnable(Long articleId, Integer isEnable);

    void deleteArticle(Long articleId);

    Integer countByArticleInputDate(Date articleInputDate);

    Long count();

}
