package com.tensquare.entity;

import java.util.List;

public class PageResult<T> {
    //返回总记录数
    private int total;
    //返回记录列表
    private List<T> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageResult(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
