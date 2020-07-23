package com.atguigu.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter执行的模拟
 * 
 * @author wzg
 *
 */
public class FilterChain {

	private int pos = 0;
	private List<Filter> filters = new ArrayList<Filter>();
	private Servlet servlet;

	public FilterChain() {
		for (int i = 0; i < 3; i++) {
			filters.add(new Filter("Filter-" + i));
		}
		servlet = new Servlet();
	}

	static class Filter {
		String filterName;

		public Filter(String filterName) {
			this.filterName = filterName;
		}

		public void doFilter(String request, String response, FilterChain chain) throws Exception {
			Thread.sleep(500);
			System.out.println(filterName + " -- begin ……");
			chain.doFilter(request, response);
			System.out.println(filterName + " -- end ……");
			Thread.sleep(500);
		}
	}

	static class Servlet {
		public void service(String request, String response) throws InterruptedException {
			Thread.sleep(1000);
			System.out.println("这是Servlet，或者是jsp，或其他资源的操作");
		}
	}

	public void doFilter(String request, String response) throws Exception {
		// 判断当前索引
		if (pos < filters.size()) {
			Filter filter = filters.get(pos++);
			filter.doFilter(request, response, this);
		} else {
			servlet.service(request, response);
		}
	}

	public static void main(String[] args) throws Exception {

		new FilterChain().doFilter("这是请求", "这是响应");

	}

}
