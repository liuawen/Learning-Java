package com.itheima.controller;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 日期控制器类
 */
@Controller
public class DateController {
	/**
	 * 使用自定义类型数据绑定日期数据
	 */
	@RequestMapping("/customDate")
	public String CustomDate(Date date) {
	    System.out.println("date="+date);
	    return "success";
	}
}
