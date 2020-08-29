package com.tensquare.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Map;

public class MybatisPlusPubFuns {

    /**
     * 构建mybatis plus where查询条件类EntityWrapper
     * @param whereMap
     * @param <T>
     * @return
     */
    public static <T> QueryWrapper<T> createEntityWrapper(Map whereMap) {
        QueryWrapper<T> qw = new QueryWrapper<T>();

        if(null != whereMap && 0 < whereMap.size()) {
            for(Object key : whereMap.keySet()) {
                qw.like(String.valueOf(key), whereMap.get(key).toString());
            }
        }

        return qw;
    }
}
