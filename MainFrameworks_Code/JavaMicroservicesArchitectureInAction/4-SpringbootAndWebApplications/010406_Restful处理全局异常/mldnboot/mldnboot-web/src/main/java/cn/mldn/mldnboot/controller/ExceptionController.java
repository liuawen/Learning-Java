package cn.mldn.mldnboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
	@GetMapping("/exception")
	public String exception() {
		int result = 10 / 0 ; 	// 此处产生异常
		return "www.liuawen.cn" ;
	}
}
