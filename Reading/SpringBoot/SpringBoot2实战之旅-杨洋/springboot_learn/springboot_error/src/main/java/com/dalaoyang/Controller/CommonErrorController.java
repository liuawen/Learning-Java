package com.dalaoyang.Controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.Controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/28
 */
@RestController
public class CommonErrorController implements ErrorController {

    private final String ERROR_PATH = "/error";


    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH)
    public String handleError(){
        System.out.println(getErrorPath());
        return "error";
    }
}
