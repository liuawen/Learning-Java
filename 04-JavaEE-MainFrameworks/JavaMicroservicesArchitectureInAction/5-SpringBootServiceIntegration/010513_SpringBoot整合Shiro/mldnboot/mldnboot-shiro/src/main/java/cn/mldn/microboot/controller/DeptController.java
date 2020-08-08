package cn.mldn.microboot.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mldn.microboot.service.IDeptService;
@Controller 
public class DeptController {
	@Resource
	private IDeptService deptService ;
	@RequiresRoles("dept")
	@RequestMapping("/pages/back/dept_list")
	public String list(Model model) {
		model.addAttribute("allDepts", this.deptService.list()) ;
		return "back/admin/dept/dept_list" ; 
	}

}
