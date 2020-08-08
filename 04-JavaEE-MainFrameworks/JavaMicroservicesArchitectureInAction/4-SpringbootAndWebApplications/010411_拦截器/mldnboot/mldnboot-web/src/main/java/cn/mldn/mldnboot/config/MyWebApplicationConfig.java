package cn.mldn.mldnboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.mldn.mldnboot.util.interceptor.MyInterceptor;
@Configuration
public class MyWebApplicationConfig extends WebMvcConfigurerAdapter {	// 定义MVC配置
	@Override
	public void addInterceptors(InterceptorRegistry registry) {	// 进行拦截器的注册处理操作
		//匹配路径
		registry.addInterceptor(new MyInterceptor())
				.addPathPatterns("/upload_pre");	// 匹配路径
		//addPathPatterns("/*.html")
		//配置的访问路径为全部请求路径，这样不管用户如何访问都会先执行拦截器中的处理方法。
		//addPathPatterns("/**")
		super.addInterceptors(registry);
	}
}
