package com.dalaoyang.dao;

import com.dalaoyang.entity.WebsiteSystemProperty;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dalaoyang
 * @Description
 * @project dalaoyang
 * @package com.dalaoyang.dao
 * @email yangyang@dalaoyang.cn
 * @date 2018/6/25
 */
@Mapper
public interface WebsiteSystemPropertyDao {

    /***
     * get blog base data
     *
     * @author dalaoyang
     * @date 2018/11/15
     * @return : com.dalaoyang.entity.WebsiteSystemProperty
     */
    WebsiteSystemProperty getWebsiteSystemProperty();
}
