package cn.mldn.mldnboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication	// 启动SpringBoot程序，而后自带子包扫描
public class SpringBootStartApplication { // 必须继承指定的父类
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootStartApplication.class, args);	// 启动SpringBoot程序
	}
}
