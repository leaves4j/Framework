package com.leaves.framework.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * User: jiangq
 * Date: 2015/2/5
 * Time: 15:51
 * Description:异常处理
 */
public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest renderRequest, HttpServletResponse renderResponse, Object o, Exception e) {
        //TODO 异常处理页面、异常日志写入
        Logger logger;
        if (o instanceof HandlerMethod) {
            logger = LoggerFactory.getLogger("");
            logger.error(((HandlerMethod) o).getBeanType().getName(), e);
        } else {
            logger = LoggerFactory.getLogger(o.getClass());
            logger.error(o.getClass().getName(), e);
        }
        return null;
    }
}
