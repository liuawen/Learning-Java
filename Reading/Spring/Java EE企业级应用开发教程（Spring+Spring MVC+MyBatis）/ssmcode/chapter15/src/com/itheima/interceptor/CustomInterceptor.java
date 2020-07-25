package com.itheima.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 实现了HandlerInterceptor接口的自定义拦截器类
 */
public class CustomInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, 
		HttpServletResponse response, Object handler)throws Exception {
		System.out.println("CustomInterceptor...preHandle");
         //对拦截的请求进行放行处理 
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, 
		HttpServletResponse response, Object handler, 
		ModelAndView modelAndView) throws Exception {
		System.out.println("CustomInterceptor...postHandle");
	}
	@Override
	public void afterCompletion(HttpServletRequest request, 
		HttpServletResponse response, Object handler, 
		Exception ex) throws Exception {		
		System.out.println("CustomInterceptor...afterCompletion");
	}
}
