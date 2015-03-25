package com.leaves.framework.common.controller;

import com.leaves.framework.common.annotation.Auth;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * User: jiangq
 * Date: 2015/1/6
 * Time: 10:45
 * Description:全局拦截器，登陆校验、注入用户session
 */
public class GlobalInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (handler instanceof HandlerMethod) {
            Auth auth = ((HandlerMethod) handler).getBeanType().getAnnotation(Auth.class);
            if (auth != null) {
                @SuppressWarnings("unchecked")
                Method method = auth.authClass().getMethod("preHandler",
                        HttpServletRequest.class, HttpServletResponse.class, HandlerMethod.class);
                return (Boolean) method.invoke(auth.authClass().newInstance(), request, response, handler);
            } else return super.preHandle(request, response, handler);
        } else {
            return super.preHandle(request, response, handler);
        }
    }

}

