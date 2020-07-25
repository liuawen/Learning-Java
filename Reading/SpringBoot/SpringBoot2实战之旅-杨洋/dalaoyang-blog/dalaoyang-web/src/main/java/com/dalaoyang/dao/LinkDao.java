package com.dalaoyang.dao;

import com.dalaoyang.entity.LinkInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dalaoyang
 * @Description
 * @project dalaoyang
 * @package com.dalaoyang.dao
 * @email yangyang@dalaoyang.cn
 * @date 2018/5/17
 */
@Mapper
public interface LinkDao {

    /***
     * getLinkList
     * @author dalaoyang
     * @date 2018/11/15
     * @return : java.util.List<com.dalaoyang.entity.LinkInfo>
     */
    List<LinkInfo> getLinkList();
}
