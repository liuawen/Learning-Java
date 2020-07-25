package com.dalaoyang.dao;

import com.dalaoyang.entity.WebsiteSystemProperty;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WebsiteSystemPropertyDao {

    WebsiteSystemProperty getWebsiteSystemProperty();

    void updateSystemProperty(WebsiteSystemProperty websiteSystemProperty);
}
