package cn.mldn.mldnboot.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice							// 使用Rest风格返回
public class GlobalExceptionAdvice {
	@ExceptionHandler(Exception.class) 			// 处理所有异常
	public Object defaultErrorHandler(HttpServletRequest request,Exception e) {
		class ErrorInfo {						// 错误提示信息
			private Integer code ;
			private String message ;
			private String url ;
			// setter、getter略
			public Integer getCode() {
				return code;
			}
			public void setCode(Integer code) {
				this.code = code;
			}
			public String getMessage() {
				return message;
			}
			public void setMessage(String message) {
				this.message = message;
			}
			public String getUrl() {
				return url;
			}
			public void setUrl(String url) {
				this.url = url;
			}
		}
		ErrorInfo info = new ErrorInfo() ;
		info.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());// 状态码
		info.setMessage(e.getMessage());					// 保存错误信息
		info.setUrl(request.getRequestURL().toString());	// 保存错误路径
		return info ;
	}
}

