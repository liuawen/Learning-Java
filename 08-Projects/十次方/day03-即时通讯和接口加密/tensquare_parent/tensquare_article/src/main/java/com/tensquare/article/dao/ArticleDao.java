package com.tensquare.article.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tensquare.article.pojo.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends BaseMapper<Article> {

    @Update("update tb_article set state='1' where id=#{id}")
    public void examine(@Param(value = "id") String id);

    @Update("update tb_article set thumbup=thumbup+1 where id=#{id}")
    public void updateThumbup(@Param(value = "id") String id);

}
