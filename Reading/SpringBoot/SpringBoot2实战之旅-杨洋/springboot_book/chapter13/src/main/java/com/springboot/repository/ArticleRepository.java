package com.springboot.repository;

import com.springboot.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {

    Page<Article> findAllByIsTopAndIsEnable(Integer isTop, Integer isEnable, Pageable pageable);

    Article findByIsEnableAndArticleId(Integer isEnable,Long articleId);

    Page<Article> findAllByIsEnable(Integer isEnable, Pageable pageable);
}
