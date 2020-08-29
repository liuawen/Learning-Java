package com.tensquare.base.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.util.IdWorker;
import com.tensquare.util.MybatisPlusPubFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        //select * from tb_label
        return labelDao.selectList(null);
    }

    public Label findById(String id) {
        return labelDao.selectById(id);
    }

    public void add(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.insert(label);
    }

    public void update(Label label) {

        labelDao.updateById(label);
    }

    public void delete(Label label) {
        labelDao.deleteById(label.getId());
    }

    public IPage search(Map whereMap, int page, int size) {

        QueryWrapper<Label> wapper = MybatisPlusPubFuns.createEntityWrapper(whereMap);
        // 执行查询
        IPage<Label> p = new Page<Label>(page, size);
        p = labelDao.selectPage(p, wapper);
        return p;
    }
}
