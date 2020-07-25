package com.springboot.service.impl;

import com.springboot.constants.Constants;
import com.springboot.entity.Article;
import com.springboot.entity.Pages;
import com.springboot.entity.Tag;
import com.springboot.repository.ArticleRepository;
import com.springboot.service.ArticleService;
import com.springboot.service.TagService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TagService tagService;

    @Override
    public Article findArticleByArticleId(Long articleId) {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        if (!optionalArticle.isPresent()) {
            return null;
        }
        Article article = optionalArticle.get();
        List<Tag> tagList = article.getTagList();
        if (CollectionUtils.isNotEmpty(tagList)) {
            List<String> tagNameList = tagList.stream().map(e -> e.getTagName()).collect(Collectors.toList());
            article.setTagsStr(StringUtils.join(tagNameList.toArray(), ","));
        }
        return article;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void saveOrUpdateArticle(Article article) {
        String tagsStr = article.getTagsStr();
        List<Tag> tagList = new ArrayList<>();
        if (StringUtils.isNotBlank(tagsStr)) {
            String[] tagNames = tagsStr.split(",");
            for (String tagName : tagNames) {
                Tag tag = tagService.findTagByTagName(tagName);
                if (tag == null) {
                    tag = new Tag(tagName);
                    tag.setTagInputDate(new Date());
                }
                tag = tagService.saveTag(tag);
                tagList.add(tag);
            }
        }
        article.setTagList(tagList);
        if (article.getArticleId() == null) {
            article.setIsEnable(Constants.NO);
            article.setArticleInputDate(new Date());
            article.setArticleInputUser(1L);
            article.setArticleReadingTime(0);
        }
        articleRepository.save(article);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void updateArticleIsEnable(Long articleId, Integer isEnable) {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            article.setIsEnable(isEnable);
            articleRepository.save(article);
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }

    @Override
    public Page<Article> findAllBySearch(Pages pages, Long articleId, String articleName, String articleAuthors) {
        Pageable pageable = PageRequest.of(pages.getPage(), pages.getPageSize(), Sort.Direction.DESC, "articleId");
        return articleRepository.findAll(this.getWhereClause(articleId, articleName, articleAuthors), pageable);
    }

    @Override
    public Integer countByArticleInputDate(Date articleInputDate) {
        return articleRepository.countByArticleInputDate(articleInputDate);
    }

    @Override
    public Long count() {
        return articleRepository.count();
    }

    /**
     * 动态生成where语句
     *
     * @param articleId,articleName,articleAuthor
     * @return
     */
    private Specification<Article> getWhereClause(Long articleId, String articleName, String articleAuthors) {
        return new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicate = new ArrayList<>();
                if (articleId != null) {
                    predicate.add(
                            cb.or(cb.equal(root.get("articleId"), articleId))
                    );
                }
                if (!StringUtils.isEmpty(articleName)) {
                    predicate.add(
                            cb.or(cb.like(root.get("articleName"), articleName + "%"))
                    );
                }
                if (!StringUtils.isEmpty(articleAuthors)) {
                    predicate.add(
                            cb.or(cb.like(root.get("articleAuthors"), articleAuthors + "%"))
                    );
                }
                Predicate[] pre = new Predicate[predicate.size()];
                return query.where(predicate.toArray(pre)).getRestriction();
            }
        };
    }
}
