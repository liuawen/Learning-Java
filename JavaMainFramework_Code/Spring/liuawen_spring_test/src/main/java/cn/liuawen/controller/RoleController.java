package cn.liuawen.controller;

import cn.liuawen.domain.Role;
import cn.liuawen.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author : Liu Awen Email:willowawen@gmail.com
 * @create : 2020-06-13
 * Web层
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    //和IoC 容器 要Service 没有配置 去配置了  放到Spring容器
    //@Controller解决  但要扫描下 spring-mvc配置文件 加个组件扫描
//    @Autowired  注解  setRoleService可以省略掉去
    @Autowired
    private RoleService roleService;

/*
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
*/

    @RequestMapping("/list")
    @ResponseBody
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        //设置模型对象
        modelAndView.addObject("roleList",roleList);
        //设置视图  pages .jsp 都设置完了
        modelAndView.setViewName("role-list");
        return modelAndView;
    }
    @RequestMapping("save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/list";
    }
}
