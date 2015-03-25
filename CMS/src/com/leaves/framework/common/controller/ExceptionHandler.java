package com.leaves.framework.common.controller;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * User: jiangq
 * Date: 2015/2/5
 * Time: 15:51
 * Description:
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest renderRequest, HttpServletResponse renderResponse, Object o, Exception e) {
       //TODO 异常处理页面、异常日志写入
        return null;
    }
}
