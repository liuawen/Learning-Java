package com.springboot.repository;

import com.springboot.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;


@Component
public interface ArticleRepository extends ElasticsearchRepository<Article,Long> {
}
