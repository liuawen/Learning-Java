package com.atguigu.bean;

import java.util.List;

public class Page<T> {

	public static final long PAGE_SIZE = 4;

	// 总共的记录数 select count(*)
	private long totalCount;
	// 每页显示的记录数 可以设定
	private long pageSize = PAGE_SIZE;
	// 总的页数 公式：总记录数 / 每页显示记录数
	private long pageTotal;
	// 当前页码 参数获取
	private long pageNo;
	// 当前页显示的数据集合 select * from t_book limit begin , size;
	private List<T> items;
	
	// 不是模块分页的不同连接地址
	private String url;

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(long totalCount, long pageSize, long pageTotal, long pageNo, List<T> items) {
		super();
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.pageTotal = pageTotal;
		this.pageNo = pageNo;
		this.items = items;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(long pageTotal) {
		this.pageTotal = pageTotal;
	}
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {
		// 检查数据的有效边界
		if (pageNo < 1) {
			pageNo = 1;
		}
		if (pageNo > pageTotal) {
			pageNo = pageTotal;
		}
		
		this.pageNo = pageNo;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Page [totalCount=" + totalCount + ", pageSize=" + pageSize + ", pageTotal="
				+ pageTotal + ", pageNo=" + pageNo + ", items=" + items + "]";
	}

}
