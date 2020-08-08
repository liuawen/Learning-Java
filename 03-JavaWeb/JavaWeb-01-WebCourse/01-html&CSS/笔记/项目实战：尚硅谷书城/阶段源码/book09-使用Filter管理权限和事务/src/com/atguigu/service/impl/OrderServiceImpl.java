package com.atguigu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;
	private OrderItemDao orderitemDao;
	private BookDao bookDao;

	public OrderServiceImpl() {
		super();
		
		orderDao = new OrderDaoImpl();
		orderitemDao = new OrderItemDaoImpl();
		bookDao = new BookDaoImpl();
	}

	@Override
	public String saveOrder(Cart cart, int userId) throws Exception {
		// 创建订单对象
		Order order = new Order();
		order.setCreateTime(new Date());
		order.setTotalMoney(cart.getTotalMoney());
		order.setUserId(userId);
		order.setStatus(0);
		// 生成订单号
		String orderId = System.currentTimeMillis() + "" + userId;
		order.setOrderId(orderId);
		// 保存订单
		orderDao.saveOrder(order);
		
		// 遍历购物车中有每一个商品
		List<OrderItem> items = new ArrayList<OrderItem>();
		for (CartItem cartItem : cart.getItems().values()) {
			// 生成订单项
			OrderItem orderItem = new OrderItem(0, cartItem.getName(), cartItem.getCount(),
					cartItem.getPrice(), cartItem.getTotalMoney(), orderId);
//			// 保存订单项
//			orderitemDao.saveOrderItem(orderItem);
			items.add(orderItem);
			// 修改图书的库存和销量
			Book book = bookDao.findBookById(cartItem.getId());
			book.setStock( book.getStock() - cartItem.getCount() );
			book.setSales( book.getSales() + cartItem.getCount() );
			bookDao.update(book);
		}
		// 批量插入
		orderitemDao.batchSaveOrderItem(items);
		// 清空购物车
		cart.clear();
		
		return orderId;
	}

	@Override
	public List<Order> queryMyOrders(int userId) throws Exception {
		// 查找自己的订单
		return orderDao.queryMyOrders(userId);
	}

	@Override
	public List<OrderItem> queryOrderItems(String orderId) throws Exception {
		// 查找某个订单的订单项
		return orderitemDao.queryOrderItems(orderId);
	}

	@Override
	public List<Order> queryAllOrders() throws Exception {
		// 查询所有订单
		return orderDao.queryAllOrders();
	}

	@Override
	public void sendOrder(String orderId) throws Exception {
		// 修改订单状态为已发货
		orderDao.updateOrderStatus(1, orderId);
	}

	@Override
	public void receivedOrder(String orderId) throws Exception {
		// 修改订单状态为已发货
		orderDao.updateOrderStatus(2, orderId);
	}

}
