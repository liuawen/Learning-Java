package cn.mldn.mldnboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ExceptionController {
	@GetMapping("/exception")
	public String exception() {
		//搞个异常来
		int a = 10 / 0;
		return "liuawen.cn" ;
	}
}
