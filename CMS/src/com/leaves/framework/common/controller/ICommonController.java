package com.leaves.framework.common.controller;

/**
 * User: jiangq
 * Date: 2015/1/7
 * Time: 13:39
 * Description:通用Controller接口
 */
public interface ICommonController {

    boolean getNeedLogin();

    String getRedirectURL();

    void setCurrentContext(CurrentContext context);

    void setLog(String info);
}
