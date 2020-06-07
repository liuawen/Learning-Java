package cn.mldn.mldnboot.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig {
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				ErrorPage errorPage404 = new ErrorPage(
						HttpStatus.NOT_FOUND, "/error-404.html");	// 定义404错误页的状态码与跳转映射路径
				ErrorPage errorPage500 = new ErrorPage(
						HttpStatus.INTERNAL_SERVER_ERROR, "/error-500.html");	// 定义500错误页的状态码与跳转映射路径
				container.addErrorPages(errorPage404, errorPage500);	// 追加错误页
			}
		};
	}
}
