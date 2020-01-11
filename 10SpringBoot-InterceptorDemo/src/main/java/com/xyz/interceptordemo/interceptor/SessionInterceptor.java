package com.xyz.interceptordemo.interceptor;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if("/user/login".equals(request.getRequestURL()) || "/user/login_view".equals(request.getRequestURL())) {
            return true;
        }
        Object object = request.getSession().getAttribute("_session_user");
        if( object == null ) {
            response.sendRedirect("/user1/login_view");
            return false;
        }

        return true;
    }
}
