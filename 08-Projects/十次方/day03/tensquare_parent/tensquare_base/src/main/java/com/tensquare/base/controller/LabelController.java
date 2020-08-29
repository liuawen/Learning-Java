package com.tensquare.base.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping
    public Result findAll() {
        List list = labelService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable String id) {
        Label label = labelService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", label);
    }

    //新增标签数据接口
    @PostMapping
    public Result add(@RequestBody Label label) {
        labelService.add(label);

        return new Result(true, StatusCode.OK, "添加成功");
    }

    //修改标签数据接口
    @PutMapping
    public Result update(@RequestBody Label label) {
        labelService.update(label);

        return new Result(true, StatusCode.OK, "修改成功");
    }

    //删除标签数据接口
    @DeleteMapping
    public Result delete(@RequestBody Label label) {
        labelService.delete(label);

        return new Result(true, StatusCode.OK, "删除成功");
    }

    @PostMapping("/search/{page}/{size}")
    public Result search(@RequestBody Map map, @PathVariable int page, @PathVariable int size) {
        IPage page1 = labelService.search(map, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult((int) page1.getTotal(), page1.getRecords()));
    }

    @GetMapping(value="/exception")
    @CrossOrigin
    public Result exception() throws Exception {
        throw new Exception("测试统一异常处理");
    }
}
