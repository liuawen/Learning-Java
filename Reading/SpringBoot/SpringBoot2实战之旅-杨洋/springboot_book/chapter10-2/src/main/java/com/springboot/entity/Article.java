package com.springboot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;


@Document(indexName = "testes" , type = "article")
@Mapping(mappingPath = "test.json")
public class Article {

    @Id
    private Long id;
    private String articleName;
    private String articleContent;
    private Integer readCount;
    private String authorName;
    private Integer authorAge;
    private String authorAddress;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(Integer authorAge) {
        this.authorAge = authorAge;
    }

    public String getAuthorAddress() {
        return authorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Article() {
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Article(Long id, String articleName, String articleContent, Integer readCount) {
        this.id = id;
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.readCount = readCount;
    }

    public Article(String articleName, String articleContent, Integer readCount) {
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.readCount = readCount;
    }

    public Article(Long id, String articleName, String articleContent, Integer readCount, String authorName, Integer authorAge, String authorAddress) {
        this.id = id;
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.readCount = readCount;
        this.authorName = authorName;
        this.authorAge = authorAge;
        this.authorAddress = authorAddress;
    }

    public Article(String articleName, String articleContent, Integer readCount, String authorName, Integer authorAge, String authorAddress) {
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.readCount = readCount;
        this.authorName = authorName;
        this.authorAge = authorAge;
        this.authorAddress = authorAddress;
    }
}
