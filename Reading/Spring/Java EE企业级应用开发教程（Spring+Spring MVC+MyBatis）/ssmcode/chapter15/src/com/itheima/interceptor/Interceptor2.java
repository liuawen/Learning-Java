package com.itheima.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 以实现接口的方式定义拦截器
 */
public class Interceptor2 implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, 
		HttpServletResponse response, Object handler) throws Exception {
		System.out.println("Interceptor2...preHandle");
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, 
		HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
		System.out.println("intercepter2...postHandle");
	}
	@Override
	public void afterCompletion(HttpServletRequest request, 
		HttpServletResponse response, Object handler, Exception ex)
		throws Exception {
		System.out.println("Intercepter2...afterCompletion");
	}
}
