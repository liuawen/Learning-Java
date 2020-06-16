package cn.mldn.mldnboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication	// 启动SpringBoot程序，而后自带子包扫描
@EnableScheduling	// 启用调度
public class SpringBootStartApplication { // 必须继承指定的父类
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootStartApplication.class, args);	// 启动SpringBoot程序
	}
} 
