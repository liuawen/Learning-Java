package com.itheima.po;

import java.util.List;

/**
 * 订单持久化类
 */
public class Orders {
	private Integer id;    //订单id
	private String number;//订单编号
	//关联商品集合信息
	private List<Product> productList;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
//	@Override
//	public String toString() {
//		return "Orders [id=" + id + ", number=" + number + "]";
//	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", number=" + number + ", productList=" + productList + "]";
	}
	
}
