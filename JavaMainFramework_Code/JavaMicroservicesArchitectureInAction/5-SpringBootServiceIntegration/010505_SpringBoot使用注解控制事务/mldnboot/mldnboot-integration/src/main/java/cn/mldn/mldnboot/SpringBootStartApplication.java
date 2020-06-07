package cn.mldn.mldnboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableJpaRepositories(basePackages="cn.mldn.mldnboot.dao")
@SpringBootApplication	// 启动SpringBoot程序，而后自带子包扫描
@EnableTransactionManagement
public class SpringBootStartApplication { // 必须继承指定的父类
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootStartApplication.class, args);	// 启动SpringBoot程序
	}
} 
