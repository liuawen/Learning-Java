package com.springboot;

import com.springboot.filter.MyFilter;
import com.springboot.interceptor.MyInterceptor;
import com.springboot.listener.MyHttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Chapter114Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Chapter114Application.class, args);
	}


	@Autowired
	private MyInterceptor myInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInterceptor);
	}


	@Bean
	public FilterRegistrationBean filterRegist() {
		FilterRegistrationBean frBean = new FilterRegistrationBean();
		frBean.setFilter(new MyFilter());
		frBean.addUrlPatterns("/*");
		return frBean;
	}

	@Bean
	public ServletListenerRegistrationBean listenerRegist() {
		ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
		srb.setListener(new MyHttpSessionListener());
		return srb;
	}
}

