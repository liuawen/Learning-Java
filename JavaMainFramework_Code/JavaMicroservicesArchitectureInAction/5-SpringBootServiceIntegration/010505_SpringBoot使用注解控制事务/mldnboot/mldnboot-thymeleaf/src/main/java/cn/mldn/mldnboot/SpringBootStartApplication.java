package cn.mldn.mldnboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication	// 启动SpringBoot程序，而后自带子包扫描
// @ImportResource(locations={"classpath:spring/spring-util.xml"})
public class SpringBootStartApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootStartApplication.class, args);	// 启动SpringBoot程序
	}
}
