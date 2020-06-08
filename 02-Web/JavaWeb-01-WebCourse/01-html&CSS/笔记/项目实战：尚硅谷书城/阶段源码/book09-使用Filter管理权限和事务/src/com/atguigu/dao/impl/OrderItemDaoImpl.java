package com.atguigu.dao.impl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao {

	/**
	 * 保存订单项
	 * 
	 * @param item
	 *            保存的订单项
	 * @throws SQLException 
	 */
	public void saveOrderItem(OrderItem item) throws SQLException {
		// 插入sql语句
		String sql = "insert into t_order_item(`name`,`price`,`total_money`,`count`,`order_id`) values(?,?,?,?,?)";
		// 执行sql
		update(sql, item.getName(), item.getPrice(), item.getTotalMoney(), item.getCount(),
				item.getOrderId());
	}

	/**
	 * 查询订单项
	 * 
	 * @param orderId
	 *            查询的订单号
	 * @throws Exception 
	 */
	public List<OrderItem> queryOrderItems(String orderId) throws Exception {
		// sql语句
		String sql = "select id,name,price,total_money totalMoney,count,order_id orderId from t_order_item where order_id = ?";
		// 执行sql语句
		List<OrderItem> result = queryList(sql, orderId);
		// 返回
		return result;
	}

	@Override
	public void batchSaveOrderItem(Collection<OrderItem> items) throws Exception {
		// 插入sql语句
		String sql = "insert into t_order_item(`name`,`price`,`total_money`,`count`,`order_id`) values(?,?,?,?,?)";
		// 创建一个二组数组
		Object[][] params = new Object[items.size()][5];
		int i = 0;
		// 遍历每一个订单项，创建参数
		for (OrderItem item : items) {
			Object[] oneParams = params[i];
			oneParams[0] = item.getName();
			oneParams[1] = item.getPrice();
			oneParams[2] = item.getTotalMoney();
			oneParams[3] = item.getCount();
			oneParams[4] = item.getOrderId();
			i++;
		}
		// 执行sql
		batch(sql, params);
	}

}
