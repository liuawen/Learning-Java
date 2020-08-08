package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.atguigu.util.JDBCUtils;

/**
 * TrasactionFilter类用于管理事务
 */
public class TransactionFilter implements Filter {

	public TransactionFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			// 放行操作
			chain.doFilter(request, response);
			// 关闭连接，并提交事务
			JDBCUtils.closeConnection();
		} catch (Exception e) {
			// 回滚 事务
			JDBCUtils.rollback();
			throw e;
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
