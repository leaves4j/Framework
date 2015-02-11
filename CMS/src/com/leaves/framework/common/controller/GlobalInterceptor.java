package com.leaves.framework.common.controller;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        if (handler instanceof ICommonController) {
            ICommonController commonController = (ICommonController) handler;
            Object session = request.getSession().getAttribute("Sys_CurrentContext");
            CurrentContext context = session == null ? null : (CurrentContext) session;
            if (context == null && commonController.getNeedLogin()) {

                //普通请求返回重定向，ajax请求返回401
                if (request.getHeader("X-Requested-With") == null)
                    response.sendRedirect(commonController.getRedirectURL());
                else
                    response.setStatus(401);
                return false;
            } else {
                commonController.setCurrentContext(context);
                commonController.setLog("");
                return super.preHandle(request, response, handler);
            }
        } else {
            return super.preHandle(request, response, handler);
        }
    }
}

