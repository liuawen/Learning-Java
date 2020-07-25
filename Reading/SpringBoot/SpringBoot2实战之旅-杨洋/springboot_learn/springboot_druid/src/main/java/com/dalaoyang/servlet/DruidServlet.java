package com.dalaoyang.servlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;
/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.servlet
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/12
 */


@WebServlet(urlPatterns="/druid/*",
        initParams={
                @WebInitParam(name="allow",value=""),// IP白名单(没有配置或者为空，则允许所有访问)
                @WebInitParam(name="deny",value=""),// IP黑名单 (deny优先于allow)
                @WebInitParam(name="loginUsername",value="admin"),// 登录druid管理页面用户名
                @WebInitParam(name="loginPassword",value="admin")// 登录druid管理页面密码
        })
public class DruidServlet extends StatViewServlet {

}
