package com.leaves.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

/**
 * User: jiangq
 * Date: 2015/1/8
 * Time: 17:39
 * Description:系统欢迎页面控制器
 */
@Controller
public class WelcomeController {
    @RequestMapping(value = "/Welcome", method = RequestMethod.GET)
    public ModelAndView getLoginPage(Model model, HttpServletRequest request) {
        String a = request.getPathInfo();
        System.out.println("getRequestURL: " + request.getRequestURL());
        System.out.println("getRequestURI: " + request.getRequestURI());
        System.out.println("getQueryString: " + request.getQueryString());
        System.out.println("getRemoteAddr: " + request.getRemoteAddr());
        System.out.println("getRemoteHost: " + request.getRemoteHost());
        System.out.println("getRemotePort: " + request.getRemotePort());
        System.out.println("getRemoteUser: " + request.getRemoteUser());
        System.out.println("getLocalAddr: " + request.getLocalAddr());
        System.out.println("getLocalName: " + request.getLocalName());
        System.out.println("getLocalPort: " + request.getLocalPort());
        System.out.println("getMethod: " + request.getMethod());
        System.out.println("-------request.getParamterMap()-------");
        //得到请求的参数Map，注意map的value是String数组类型
        Map map = request.getParameterMap();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String[] values = (String[]) map.get(key);
            for (String value : values) {
                System.out.println(key + "=" + value);
            }
        }
        int i = 1 / 0;
        System.out.println("--------request.getHeader()--------");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("FrameWork/view/welcome");
        return mv;
    }
}
