package com.dalaoyang.dao;

import com.dalaoyang.entity.WebsiteAccessInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dalaoyang
 * @Description
 * @project dalaoyang
 * @package com.dalaoyang.dao
 * @email yangyang@dalaoyang.cn
 * @date 2018/12/15
 */
@Mapper
public interface WebsiteAccessInfoDao {

    List<WebsiteAccessInfo> getThisWeekWebsiteAccessInfo();
}
