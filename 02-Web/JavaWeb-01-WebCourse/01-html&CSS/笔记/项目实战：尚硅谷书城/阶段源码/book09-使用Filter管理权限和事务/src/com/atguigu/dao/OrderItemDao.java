package com.atguigu.dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.atguigu.bean.OrderItem;

public interface OrderItemDao {
	/**
	 * 保存订单项
	 * 
	 * @param item
	 *            保存的订单项
	 * @throws SQLException 
	 */
	public void saveOrderItem(OrderItem item) throws SQLException;

	/**
	 * 保存订单项
	 * 
	 * @param item
	 *            保存的订单项
	 * @throws Exception 
	 */
	public void batchSaveOrderItem(Collection<OrderItem> items) throws Exception;

	/**
	 * 查询订单项
	 * 
	 * @param orderId
	 *            查询的订单号
	 * @throws Exception 
	 */
	public List<OrderItem> queryOrderItems(String orderId) throws Exception;

}
