package cn.mldn.mldnboot.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.mldn.mldnboot.util.MessageUtil;
@RestController							// 建立控制器，所有路径以Restful形式运行
public class MessageController {
	@Autowired
	private MessageSource messageSource; // 自动注入此资源对象
	@Autowired
	private MessageUtil messageUtil ;		// XML配置注入
	@GetMapping("/info")
	public Object info() {
		return this.messageUtil.getInfo() ; // 调用方法
	}
	
	@GetMapping("/message")
	public Object message() {
		Map<String,String> map = new HashMap<String,String>() ;
		map.put("welcome.url", this.messageSource.getMessage("welcome.url", null, Locale.getDefault())) ;
		map.put("welcome.msg", this.messageSource.getMessage("welcome.msg", new Object[] {"李兴华"}, new Locale("en","US"))) ;
		return map ;
	}
	
	@RequestMapping("/")				// 访问映射路径
	public String home() {				// 控制器方法
		return "www.mldn.cn";			// 返回信息
	}
	@GetMapping("/echo/{message}")								// 只支持GET请求模式
	public String echo(@PathVariable("message") String msg) {	// 接收msg参数
		return "【ECHO】" + msg ;								// 信息处理后返回
	}
	
	@GetMapping("/object")
	public Object object() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();			// 获取HttpServletRequest内置对象
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getResponse();			// 获取HttpServletResponse内置对象
		Map<String,String> map = new HashMap<String,String>() ;
		map.put("客户端IP地址", request.getRemoteAddr()) ;
		map.put("客户端响应编码", response.getCharacterEncoding()) ;
		map.put("SessionID", request.getSession().getId()) ;
		map.put("项目真实路径", request.getServletContext().getRealPath("/")) ;
		return map ; 					// 以Restful风格返回
	}

	
	
}
