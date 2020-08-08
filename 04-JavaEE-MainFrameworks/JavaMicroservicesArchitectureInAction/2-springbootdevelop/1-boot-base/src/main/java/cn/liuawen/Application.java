package cn.liuawen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//启动SpringBoot程序，而后自带子包扫描
//@Component
//@EnableAutoConfiguration

//SpringBoot强调的是零配置  不要这么使用
//@ImportResource(locations = {"classpath:spring/spring-util.xml"})
public class Application {
    //启动SpringBoot程序
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
