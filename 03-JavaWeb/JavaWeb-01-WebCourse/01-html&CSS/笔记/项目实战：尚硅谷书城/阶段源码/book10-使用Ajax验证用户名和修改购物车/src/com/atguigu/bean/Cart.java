package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 购物车中的商品信息
	 */
	private Map<Integer, CartItem> items = new HashMap<Integer, CartItem>();

	public Cart() {
		super();
	}

	/**
	 * 获取购物车中商品总数量
	 * 
	 * @return
	 */
	public int getTotalCount() {
		int totalCount = 0;
		// 遍历相加每一个商品数量
		for (Map.Entry<Integer, CartItem> item : items.entrySet()) {
			CartItem cartItem = item.getValue();
			totalCount += cartItem.getCount();
		}
		return totalCount;
	}

	/**
	 * 增加一个图书
	 * 
	 * @param book
	 */
	public void addItem(Book book) {
		// 先从购物车中取出商品
		CartItem item = items.get(book.getId());
		// 如果为null，说明之前没有此商品
		if (item == null) {
			item = new CartItem(book.getId(), book.getName(), book.getPrice(), book.getPrice(), 1);
			items.put(book.getId(), item);
		} else {
			// 非空说明原来购物车中有此商品。修改商品数量和总金额
			item.setCount(item.getCount() + 1);
			item.setTotalMoney(item.getPrice() * item.getCount());
		}
	}

	public static void main(String[] args) {
		// 精度测试
		double d1 = 0.01, d2 = 0.06, d3;
		d3 = d1 + d2;
		System.out.println(d3);
		// 
		d1 = 0.7;
		System.out.println(d1 + d1 + d1); // 应该是2.1
	}

	/**
	 * 清空购物车
	 */
	public void clear() {
		// 清空购物车
		items.clear();
	}

	/**
	 * 删除购物车中的商品
	 * 
	 * @param id
	 *            要删除的商品编号
	 */
	public void deleteItem(int id) {
		// 删除商品
		items.remove(id);
	}

	/**
	 * 修改购物车
	 * 
	 * @param id
	 *            要修改的商品编号
	 * @param count
	 *            修改的商品数量
	 */
	public double updateItem(int id, int count) {
		// 先从购物车中取出商品
		CartItem item = items.get(id);
		// 如果为null，说明之前没有此商品
		if (item != null) {
			// 修改商品数量和总金额
			item.setCount(count);
			item.setTotalMoney(item.getPrice() * item.getCount());
			return item.getTotalMoney();
		}
		return 0;
	}
	
	

	/**
	 * 获取所有商品
	 * 
	 * @return
	 */
	public Map<Integer, CartItem> getItems() {
		return items;
	}

	/**
	 * 获取购物车中总的商品金额
	 * 
	 * @return
	 */
	public BigDecimal getTotalMoney() {

		BigDecimal totalMoney = new BigDecimal(0);
		// 遍历商品求商品总金额
		for (Map.Entry<Integer, CartItem> item : items.entrySet()) {
			CartItem cartItem = item.getValue();
			BigDecimal t = new BigDecimal(cartItem.getTotalMoney() + "");
			totalMoney = totalMoney.add(t);
		}

		return totalMoney;
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + "\n totalCount=" + getTotalCount() + "\n totalMoney="
				+ getTotalMoney() + "]";
	}

}
