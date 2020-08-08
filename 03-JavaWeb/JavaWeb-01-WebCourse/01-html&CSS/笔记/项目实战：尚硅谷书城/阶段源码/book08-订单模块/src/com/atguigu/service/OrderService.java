package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;

public interface OrderService {

	/**
	 * 订单的生成
	 * 
	 * @param cart
	 *            购物车信息
	 * @param userId
	 *            用户id信息
	 * @return 返回订单号
	 */
	public String saveOrder(Cart cart, int userId);

	/**
	 * 我的订单列表
	 * 
	 * @param userId
	 *            用户id号
	 * @return 返回用户的订单信息
	 */
	public List<Order> queryMyOrders(int userId);

	/**
	 * 订单详情
	 * 
	 * @param orderId
	 *            要查询的订单号
	 * @return 订单详细
	 */
	public List<OrderItem> queryOrderItems(String orderId);

	/**
	 * 管理员--查看所有订单
	 */
	public List<Order> queryAllOrders();

	/**
	 * 确认发货
	 * 
	 * @param orderId
	 *            发货的订单号
	 */
	public void sendOrder(String orderId);

	/**
	 * 用户确认收货
	 * 
	 * @param orderId
	 *            收到的订单号
	 */
	public void receivedOrder(String orderId);

}
