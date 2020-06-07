package cn.mldn.mldnboot.controller;

import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mldn.mldnboot.vo.Member;

@Controller
public class MemberController {
	@GetMapping("/member_add_pre")
	public String addPre() { // 增加前的准备操作路径
		return "member_add";
	}
	@PostMapping("/member_add")
	@ResponseBody
	public Object add(@Valid Member vo, BindingResult result) { // 增加前的准备操作路径
		if (result.hasErrors()) { // 现在表示执行的验证出现错误
			Iterator<ObjectError> iterator = result.getAllErrors().iterator(); // 获取全部错误信息
			while (iterator.hasNext()) {
				ObjectError error = iterator.next() ;	// 取出每一个错误
				System.out.println("【错误信息】code = " + error.getCode() + "，message = " + error.getDefaultMessage());
			} 
			return result.getAllErrors() ;
		} else {
			return vo;
		}
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {		// 在本程序里面需要针对于日期格式进行处理
		// 首先建立一个可以将字符串转换为日期的工具程序类
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		// 明确的描述此时需要注册一个日期格式的转化处理程序类
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}
}

