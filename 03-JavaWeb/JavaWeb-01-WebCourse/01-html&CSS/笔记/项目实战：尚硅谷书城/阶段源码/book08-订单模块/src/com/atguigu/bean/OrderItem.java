package com.atguigu.bean;

/**
 * 订单项
 * 
 * @author wzg
 *
 */
public class OrderItem {

	// 编号
	private int id;
	// 商品名称
	private String name;
	// 商品数量
	private int count;
	// 单价
	private double price;
	// 总价
	private double totalMoney;
	// 订单号
	private String orderId;

	public OrderItem() {
		super();
	}

	public OrderItem(int id, String name, int count, double price, double totalMoney, String orderId) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.price = price;
		this.totalMoney = totalMoney;
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String toString() {
		return "OrderItem [id=" + id + ", name=" + name + ", count=" + count + ", price=" + price
				+ ", totalMoney=" + totalMoney + "]";
	}

}
