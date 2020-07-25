package com.dalaoyang.dao;

import com.dalaoyang.entity.WebsiteSystemInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WebsiteSystemInfoDao {

    void updateWebsiteVisits();

    void updateTodayWebsiteVisits();

    void updateMonthWebsiteVisits();

    WebsiteSystemInfo getWebsiteSystemInfo();

    void saveAccessInfo(String accessIp);


}
