package com.atguigu.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 解决中文乱码
 */
public class CharacterFilter implements Filter {

	private String charset = "UTF-8";

	public CharacterFilter() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 设置请求响应编码
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		// 将HttpSerlvetRequest替换成我们包装后的。
		chain.doFilter(new MyHttpServletRequestWapper((HttpServletRequest) request), response);
	}

	/**
	 * 创建一个HttpServletRequest的包装类
	 * 
	 * @author wzg
	 *
	 */
	static class MyHttpServletRequestWapper extends HttpServletRequestWrapper {

		private HttpServletRequest request;

		public MyHttpServletRequestWapper(HttpServletRequest request) {
			super(request);
			this.request = request;
		}

		@Override
		public String getParameter(String name) {
			// 如果是get请求
			if ("get".equalsIgnoreCase(request.getMethod())) {
				// 先获取原来的乱码值
				String value = super.getParameter(name);
				if (value != null) {
					try {
						// 然后编码，解码
						value = new String(value.getBytes("ISO-8859-1"),
								request.getCharacterEncoding());
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				return value;
			} else {
				return super.getParameter(name);
			}
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 获取初始化配置的编码
		String t = fConfig.getInitParameter("charset");
		if (t != null) {
			charset = t;
		}
	}

	public void destroy() {}

}
