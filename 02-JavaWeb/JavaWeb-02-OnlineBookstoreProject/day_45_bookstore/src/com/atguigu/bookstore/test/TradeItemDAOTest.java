package com.atguigu.bookstore.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.junit.Test;

import com.atguigu.bookstore.dao.TradeItemDAO;
import com.atguigu.bookstore.dao.impl.TradeItemDAOImpl;
import com.atguigu.bookstore.domain.TradeItem;

public class TradeItemDAOTest {

	private TradeItemDAO tradeItemDAO = new TradeItemDAOImpl();
	
	@Test
	public void testBatchSave() {
		Collection<TradeItem> items = new ArrayList<>();
		
		items.add(new TradeItem(null, 1, 10, 25));
		items.add(new TradeItem(null, 2, 20, 25));
		items.add(new TradeItem(null, 3, 30, 25));
		items.add(new TradeItem(null, 4, 40, 25));
		items.add(new TradeItem(null, 5, 50, 25));
		
		tradeItemDAO.batchSave(items);
	}

	@Test
	public void testGetTradeItemsWithTradeId() {
		Set<TradeItem> items = tradeItemDAO.getTradeItemsWithTradeId(25);
		System.out.println(items);
	}

}
