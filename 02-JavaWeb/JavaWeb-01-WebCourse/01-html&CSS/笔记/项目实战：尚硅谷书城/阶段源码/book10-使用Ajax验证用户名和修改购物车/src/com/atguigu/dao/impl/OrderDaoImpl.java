package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.Order;
import com.atguigu.dao.OrderDao;

public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

	/**
	 * 保存订单
	 * 
	 * @param order
	 *            要保存的订单
	 * @throws Exception 
	 */
	public void saveOrder(Order order) throws Exception {
		// sql语句
		String sql = "insert into t_order(`order_id`,`create_time`,`total_money`,`status`,`user_id`) values(?,?,?,?,?)";

		// 执行sql语句
		update(sql, order.getOrderId(), order.getCreateTime(), order.getTotalMoney(),
				order.getStatus(), order.getUserId());
	}

	/**
	 * 查询我的订单
	 * 
	 * @param userId
	 *            用户id
	 * 
	 * @return 用户的订单
	 * @throws Exception 
	 */
	public List<Order> queryMyOrders(int userId) throws Exception {
		// 查询我的订单
		String sql = "select `order_id` orderId,`create_time` createTime,`total_money` totalMoney,`status`,`user_id` userId from t_order where `user_id` = ?";
		// 执行sql语句
		return queryList(sql, userId);
	}

	/**
	 * 查询所有订单
	 * 
	 * @return 返回所有订单信息
	 * @throws Exception 
	 */
	public List<Order> queryAllOrders() throws Exception {
		// 查询我的订单
		String sql = "select `order_id` orderId,`create_time` createTime,`total_money` totalMoney,`status`,`user_id` userId from t_order ";
		// 执行sql语句
		return queryList(sql);
	}

	/**
	 * 修改订单状态
	 * 
	 * @param status
	 *            订单的状态
	 * @throws Exception 
	 */
	public void updateOrderStatus(int status, String orderId) throws Exception {
		// sql语句
		String sql = "update t_order set status = ? where order_id = ?";
		// 执行sql语句
		update(sql, status, orderId);
	}

}
