package com.dalaoyang.dao;

import com.dalaoyang.entity.LinkInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LinkDao {

    List<LinkInfo> getLinkListPage(Map map);

    int getLinkListCount(Map map);

    LinkInfo getLinkInfoById(Integer id);

    void editLink(Map map);

    void saveLink(Map map);

    int getLastId();

    void deleteLink(Integer id);

}
