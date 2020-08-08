package com.atguigu.dao;

import java.util.Collection;
import java.util.List;

import com.atguigu.bean.OrderItem;

public interface OrderItemDao {
	/**
	 * 保存订单项
	 * 
	 * @param item
	 *            保存的订单项
	 */
	public void saveOrderItem(OrderItem item);

	/**
	 * 保存订单项
	 * 
	 * @param item
	 *            保存的订单项
	 */
	public void batchSaveOrderItem(Collection<OrderItem> items);

	/**
	 * 查询订单项
	 * 
	 * @param orderId
	 *            查询的订单号
	 */
	public List<OrderItem> queryOrderItems(String orderId);

}
