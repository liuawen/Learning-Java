package cn.mldn.mldnboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
@SpringBootApplication	// 启动SpringBoot程序，而后自带子包扫描
public class SpringBootStartApplication extends SpringBootServletInitializer { // 必须继承指定的父类
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {						// 配置SpringBoot应用环境
		return builder.sources(SpringBootStartApplication.class) ;
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootStartApplication.class, args);	// 启动SpringBoot程序
	}
}
