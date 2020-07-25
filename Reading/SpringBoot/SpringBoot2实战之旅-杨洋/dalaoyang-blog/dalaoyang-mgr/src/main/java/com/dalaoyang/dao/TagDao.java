package com.dalaoyang.dao;

import com.dalaoyang.entity.TagInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TagDao {

    List<TagInfo> getTagByArticleId(Integer articleId);

    void saveArticleTag(Map map);

    void deleteArticleTag(int articleId);

    Integer getTagIdByName(String tagName);

    void saveTag(String tagName);

    int getLastId();

    List<TagInfo> getTagListPage(Map map);

    int getTagListCount(Map map);

    void deleteAllArticleTag(int tagId);

    void deleteTag(int tagId);

}
