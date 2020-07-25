package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class Chapter38Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter38Application.class, args);
	}

	@GetMapping("/")
	public String index(ModelMap modelMap){
		modelMap.addAttribute("msg", "文件上传下载");
		return "index";
	}
}
