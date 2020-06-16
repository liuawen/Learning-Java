package cn.mldn.mldnboot.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice													// 作为一个控制层的切面处理
public class GlobalExceptionAdvice {
	public static final String DEFAULT_ERROR_VIEW = "error"; 		// 定义错误显示页，error.html
	@ExceptionHandler(Exception.class) 								// 处理所有Exception类
	public ModelAndView defaultErrorHandler(HttpServletRequest request,
			Exception e) { 											// 出现异常之后会跳转到此方法
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW); 	// 设置跳转路径
		//跳转到error页面
		mav.addObject("exception", e); 								// 保存异常信息
		mav.addObject("url", request.getRequestURL()); 				// 获得请求的路径
		return mav;
	}
}
