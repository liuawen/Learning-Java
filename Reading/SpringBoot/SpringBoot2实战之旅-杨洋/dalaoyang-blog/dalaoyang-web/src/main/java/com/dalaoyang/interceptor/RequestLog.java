package com.dalaoyang.interceptor;

import com.dalaoyang.dao.WebsiteSystemInfoDao;
import com.dalaoyang.entity.WebsiteSystemInfo;
import com.dalaoyang.service.CommonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class RequestLog extends HandlerInterceptorAdapter {


    Logger logger = Logger.getLogger(RequestLog.class);

    @Autowired
    private WebsiteSystemInfoDao websiteSystemInfoDao;

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private CommonService commonService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String ip = request.getRemoteAddr();
        long startTime = System.currentTimeMillis();
        request.setAttribute("requestStartTime", startTime);
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取用户token
        Method method = handlerMethod.getMethod();
        logger.info("用户:" + ip + ",访问目标:" + method.getDeclaringClass().getName() + "." + method.getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        if(modelAndView!=null){
            websiteSystemInfoDao.updateWebsiteVisits();
            ModelMap modelMap = modelAndView.getModelMap();
            //访问人数
            WebsiteSystemInfo websiteSystemInfo = websiteSystemInfoDao.getWebsiteSystemInfo();
            modelMap.addAttribute("websiteSystemInfo", websiteSystemInfo);
            //最近五篇文章
            modelMap.addAttribute("commonArticleList",commonService.getCommonArticleList());
            //标签列表
            modelMap.addAttribute("tagList", commonService.getTagList());
            //友情链接列表
            modelMap.addAttribute("linkList", commonService.getLinkList());
            //项目名称
            modelMap.addAttribute("applicationName", applicationName);
            //网站信息
            modelMap.addAttribute("websiteSystemProperty", commonService.getWebsiteSystemProperty());
        }
    }
}
