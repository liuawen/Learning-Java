package com.springboot.service.impl;

import com.springboot.constants.Constants;
import com.springboot.entity.Article;
import com.springboot.repository.ArticleRepository;
import com.springboot.service.ArticleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    @Cacheable(value = "indexPageArticleList")
    public List<Article> findIsTopArticleList() {
        Pageable pageable = PageRequest.of(0, 6, Sort.Direction.DESC, "articleId");
        Page<Article> page = articleRepository.findAllByIsTopAndIsEnable(Constants.YES, Constants.YES, pageable);
        List<Article> articleList = page.getContent();
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            article.setImageNo(i + 1);
        }
        return articleList;
    }

    @Override
    @Cacheable(value = "blogArticle", key = "#page")
    public Page<Article> findBlogArticleList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "articleId");
        return articleRepository.findAllByIsEnable(Constants.YES, pageable);
    }

    @Override
    public Page<Article> findSearchArticleList(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "articleId");
        return articleRepository.findAll(this.getWhereClause(keyword), pageable);
    }

    @Override
    public Article findArticleByArticleId(Long articleId) {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        if(optionalArticle.isPresent()){
            return optionalArticle.get();
        }
        return null;
    }

    @Override
    public Article findIsEnableArticleByArticleId(Long articleId) {
        return articleRepository.findByIsEnableAndArticleId(Constants.YES, articleId);
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    /**
     * 动态生成where语句
     *
     * @param keyword
     * @return
     */
    private Specification<Article> getWhereClause(String keyword) {
        return new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();
                if (StringUtils.isNotBlank(keyword)) {
                    predicate.add(
                            cb.and(
                                    cb.or(
                                            cb.like(root.get("articleName"), "%" + keyword + "%"),
                                            cb.like(root.get("articleContent"), "%" + keyword + "%")
                                    )
                            )
                    );
                }
                predicate.add(cb.equal(root.get("isEnable"), Constants.YES));
                Predicate[] pre = new Predicate[predicate.size()];
                return query.where(predicate.toArray(pre)).getRestriction();
            }
        };
    }
}