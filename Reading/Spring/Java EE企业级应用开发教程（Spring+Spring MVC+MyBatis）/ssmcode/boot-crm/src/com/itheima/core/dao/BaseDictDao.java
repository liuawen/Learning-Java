package com.itheima.core.dao;
import java.util.List;
import com.itheima.core.po.BaseDict;
/**
 * 数据字典
 */
public interface BaseDictDao {
	// 根据类别代码查询数据字典
    public List<BaseDict> selectBaseDictByTypeCode(String typecode);
}
