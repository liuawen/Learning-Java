package com.dalaoyang.controller;

import com.dalaoyang.consts.Consts;
import com.dalaoyang.dao.LoginDao;
import com.dalaoyang.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginDao loginDao;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/checkLogin")
    public String checkLogin(@RequestParam String userName, @RequestParam String passWord,
                             HttpServletRequest request, Model model) {
        Map map = new HashMap(Consts.HASHMAP_DEFAULT_CAPACITY);
        map.put("userName", userName);
        map.put("passWord", passWord);
        UserInfo userInfo = loginDao.findUserByUserNameAndPassword(map);
        if (userInfo != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userInfo);
        } else {
            return "login";
        }
        model.addAttribute("urlPre", "index");
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "login";
    }
}
