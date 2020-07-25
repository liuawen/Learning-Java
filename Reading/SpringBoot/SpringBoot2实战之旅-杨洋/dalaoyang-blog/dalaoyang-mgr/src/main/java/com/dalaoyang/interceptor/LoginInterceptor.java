package com.dalaoyang.interceptor;

import com.dalaoyang.consts.Consts;
import com.dalaoyang.entity.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 获取用户token
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        if (!Consts.ALLOW_URL_LIST.contains(methodName)) {
            HttpSession session = request.getSession();
            UserInfo user = (UserInfo) session.getAttribute("user");
            if (user == null) {
                String path = request.getContextPath();
                response.sendRedirect(path + "login");
                return false;
            }
        }
        return true;
    }

}
