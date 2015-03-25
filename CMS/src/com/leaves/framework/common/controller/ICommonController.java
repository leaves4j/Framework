package com.leaves.framework.common.controller;

import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * User: jiangq
 * Date: 2015/1/7
 * Time: 13:39
 * Description:通用Controller接口
 */
public interface ICommonController {

     boolean preHandler(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler) throws Exception;
}
