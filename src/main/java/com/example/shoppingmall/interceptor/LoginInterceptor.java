package com.example.shoppingmall.interceptor;

import com.example.shoppingmall.utils.Const;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器，需要配置，新建WebConfig类
 * */

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getSession().getAttribute(Const.LOGIN_USER) == null){
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
