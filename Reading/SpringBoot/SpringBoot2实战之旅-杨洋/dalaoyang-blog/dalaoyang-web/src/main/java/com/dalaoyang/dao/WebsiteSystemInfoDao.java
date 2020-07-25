package com.dalaoyang.dao;

import com.dalaoyang.entity.WebsiteSystemInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author dalaoyang
 * @Description
 * @project dalaoyang
 * @package com.dalaoyang.dao
 * @email 397600342@qq.com
 * @date 2018/3/2
 */
@Mapper
public interface WebsiteSystemInfoDao {

    /***    
     * updateWebsiteVisits
     * @author dalaoyang
     * @date 2018/11/15
     * @return : void 
     */ 
    void updateWebsiteVisits();

    /***    
     * updateTodayWebsiteVisits
     * @author dalaoyang
     * @date 2018/11/15
     * @return : void
     */ 
    void updateTodayWebsiteVisits();

    /***
     * updateMonthWebsiteVisits
     * @author dalaoyang
     * @date 2018/11/15
     * @return : void
     */
    void updateMonthWebsiteVisits();

    /***
     * getWebsiteSystemInfo
     * @author dalaoyang
     * @date 2018/11/15
     * @return : com.dalaoyang.entity.WebsiteSystemInfo
     */
    WebsiteSystemInfo getWebsiteSystemInfo();

}
