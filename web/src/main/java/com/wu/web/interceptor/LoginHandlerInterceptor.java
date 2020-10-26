package com.wu.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginHandlerInterceptor
 * @Description
 * @Author wuhjie
 * @Data 2020/10/20 4:20 pm
 * @Version 1.0
 **/

public class LoginHandlerInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");

        if (user == null) {

            request.setAttribute("msg", "login plz");

            request.getRequestDispatcher("/index.html").forward(request, response);

            return false;
        }
        return true;
    }
}
