package com.atguigu.bean;

import java.io.Serializable;

/**
 * 购物车中商品模型
 * 
 * @author wzg
 *
 */
public class CartItem implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 商品编号
	 */
	private Integer id;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 商品单价
	 */
	private double price;
	/**
	 * 商品总金额
	 */
	private double totalMoney;
	/**
	 * 商品数量
	 */
	private int count;

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(Integer id, String name, double price, double totalMoney, int count) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.totalMoney = totalMoney;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", name=" + name + ", price=" + price + ", totalMoney="
				+ totalMoney + ", count=" + count + "]";
	}

}
