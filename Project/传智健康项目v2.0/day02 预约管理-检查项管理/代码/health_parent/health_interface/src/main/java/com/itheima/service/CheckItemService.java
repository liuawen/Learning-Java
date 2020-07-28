package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

//服务接口
public interface CheckItemService {
    public void add(CheckItem checkItem);
    public PageResult pageQuery(QueryPageBean queryPageBean);
    public void deleteById(Integer id);
    public void edit(CheckItem checkItem);
    public CheckItem findById(Integer id);
}
