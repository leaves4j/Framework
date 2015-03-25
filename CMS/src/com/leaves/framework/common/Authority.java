package com.leaves.framework.common;

import com.leaves.framework.common.annotation.CurrentUser;
import com.leaves.framework.common.controller.GlobalInterceptor;
import com.leaves.framework.common.controller.ICommonController;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;


/**
 * User: jiangq
 * Date: 2015/1/6
 * Time: 10:46
 * Description:登陆控制器抽象类
 */

public class Authority implements ICommonController {
    public boolean preHandler(HttpServletRequest request, HttpServletResponse response, HandlerMethod handler)
            throws Exception {

        Object session = request.getSession().getAttribute("Sys_CurrentContext");

        if (session == null) {
            if (request.getHeader("X-Requested-With") == null)
                response.sendRedirect("login");
            else
                response.setStatus(401);
            return false;
        } else {
            Field[] fields = handler.getBeanType().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(CurrentUser.class) && field.getType() == CurrentContext.class) {
                    field.setAccessible(true);

                    field.set(handler.getBean(), session);
                }
            }
            //TODO 登陆日志写入
            return true;
        }
    }
}

