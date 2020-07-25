package com.springboot.controller;

import com.springboot.constants.Constants;
import com.springboot.entity.Pages;
import com.springboot.entity.Role;
import com.springboot.entity.User;
import com.springboot.service.RoleService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public String user(Integer pageNumber, Long userId, String username, Model model) {
        Page<User> userPage = userService.findAllBySearch(Pages.defaultPages(pageNumber), userId, username);
        model.addAttribute("userList", userPage.getContent());
        model.addAttribute("totalCount", userPage.getTotalElements());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("userId", userId);
        model.addAttribute("username", username);
        model.addAttribute("menuFlag", Constants.USER_MENU_FLAG);
        return "user/index";
    }

    @GetMapping("/saveOrUpdatePage")
    public String editUser(Model model, Long userId) {
        List<Role> roleList = roleService.findAllByIsEnable();
        User user = new User();
        if (userId != null) {
            user = userService.findUserByUserId(userId);
            List userRoleList = user.getRoleList();
            for (Role role : roleList) {
                if (userRoleList.contains(role)) {
                    role.setIsHave(Constants.YES);
                }
            }
        } else {
            user.setUserId(0L);
        }
        model.addAttribute("user", user);
        model.addAttribute("menuFlag", Constants.USER_MENU_FLAG);
        model.addAttribute("roleList", roleList);
        return "user/edit";
    }

    @PostMapping("/updateUserIsEnable")
    @ResponseBody
    public void updateUserIsEnable(Long userId, Integer isEnable) {
        userService.updateUserIsEnable(userId, isEnable);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void deleteArticle(Long userId) {
        userService.deleteUser(userId);
    }

    @PostMapping("/saveOrUpdate")
    @ResponseBody
    public void saveOrUpdateUser(@RequestBody User user) {
        userService.saveOrUpdateUser(user);
    }

}
